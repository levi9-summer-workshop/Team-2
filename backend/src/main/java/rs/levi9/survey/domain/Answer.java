package rs.levi9.survey.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "answer")
public class Answer extends BaseEntity implements Serializable {


    @NotNull
    private String answer_text;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "survey_answer_id", nullable = false)
    private SurveyAnswer surveyAnswer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Answer() {
    }

    public Answer(Question question, SurveyAnswer surveyAnswer, User user) {
        this.question = question;
        this.surveyAnswer = surveyAnswer;
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public SurveyAnswer getSurveyAnswer() {
        return surveyAnswer;
    }

    public void setSurveyAnswer(SurveyAnswer surveyAnswer) {
        this.surveyAnswer = surveyAnswer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
