package rs.levi9.survey.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String isRequired = "false";

    @Column
    private String placeHolder;

    @Column
    private String title;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Choice> choices;

    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    public Question() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequired() {
        return isRequired;
    }

    public void setRequired(String required) {
        isRequired = required;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
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
