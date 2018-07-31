package rs.levi9.survey.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

    @Column
    private String type;

    @Column
    private Boolean isRequired = false;

    @Column
    private String title;

    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Choice> choices;

    public Question() {
    }

    public Question(String type, Boolean isRequired, String title, List<Choice> choices) {
        this.type = type;
        this.isRequired = isRequired;
        this.title = title;
        this.choices = choices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
