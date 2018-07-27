package rs.levi9.survey.domain;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity {

    @Column
    private String title;

    @Column
    private String showTitle = "true";

    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
