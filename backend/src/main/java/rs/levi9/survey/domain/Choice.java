package rs.levi9.survey.domain;

import javax.persistence.*;

@Entity
@Table(name = "choices")
public class Choice extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column
    private String choices;

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
