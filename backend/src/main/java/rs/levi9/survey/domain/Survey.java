package rs.levi9.survey.domain;

import javax.persistence.*;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column
    private String showTitle = "true";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }
}
