package rs.levi9.survey.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "survey_answer")
public class SurveyAnswer extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public SurveyAnswer() {
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
