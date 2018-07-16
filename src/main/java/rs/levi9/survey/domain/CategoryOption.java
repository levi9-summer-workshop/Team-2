package rs.levi9.survey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category_option")
public class CategoryOption extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public CategoryOption() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
