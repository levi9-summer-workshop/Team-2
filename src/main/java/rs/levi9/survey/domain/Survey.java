package rs.levi9.survey.domain;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String title;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryOption categoryOption;

    @Column(nullable = false)
    private String description;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date endDate;

    public Survey() {
    }

    public Survey(String title, CategoryOption categoryOption, String description, Date startDate, Date endDate) {
        this.title = title;
        this.categoryOption = categoryOption;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryOption getCategoryOption() {
        return categoryOption;
    }

    public void setCategoryOption(CategoryOption categoryOption) {
        this.categoryOption = categoryOption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
