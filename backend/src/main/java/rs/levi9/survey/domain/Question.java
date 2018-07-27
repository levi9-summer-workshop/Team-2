package rs.levi9.survey.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

public class Question extends BaseEntity{

    //connect survey id with question id
    @Column(name = "survey_id")
    private Long surveyId;

    //list of answers/choices
    //connect with question id
    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Choices> choices;

    @Size(max=240)
    @Column(name = "question_value")
    private String QuestionValue;

    @Column(name = "question_comment")
    private String questionComment;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    public String getQuestionValue() {
        return QuestionValue;
    }

    public void setQuestionValue(String questionValue) {
        QuestionValue = questionValue;
    }

    public String getQuestionComment() {
        return questionComment;
    }

    public void setQuestionComment(String questionComment) {
        this.questionComment = questionComment;
    }
}
