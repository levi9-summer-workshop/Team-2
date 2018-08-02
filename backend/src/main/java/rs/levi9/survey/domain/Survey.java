package rs.levi9.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity implements Serializable {

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private SurveyUser surveyUser;

    @Column
    @Size(max = 250)
    private String description;

    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

    @Column(name = "creation_date", updatable = false, nullable = false)
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_privacy")
    private SurveyPrivacy surveyPrivacy = new SurveyPrivacy(SurveyPrivacy.PrivacyType.PUBLIC);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_status")
    private SurveyStatus surveyStatus = new SurveyStatus(SurveyStatus.StatusType.OPEN);

    public Survey() {
    }

    public Survey(String title, String description, List<Question> questions, Date creationDate, Date expirationDate, SurveyPrivacy surveyPrivacy, SurveyStatus surveyStatus) {
        this.title = title;
        this.description = description;
        this.questions = questions;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.surveyPrivacy = surveyPrivacy;
        this.surveyStatus = surveyStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public SurveyPrivacy getSurveyPrivacy() {
        return surveyPrivacy;
    }

    public void setSurveyPrivacy(SurveyPrivacy surveyPrivacy) {
        this.surveyPrivacy = surveyPrivacy;
    }

    public SurveyStatus getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(SurveyStatus surveyStatus) {
        this.surveyStatus = surveyStatus;
    }
}
