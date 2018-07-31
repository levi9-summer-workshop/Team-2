package rs.levi9.survey.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity implements Serializable {

    @Column
    private String title;

    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Survey() {
    }

    public Survey(String title, List<Question> questions, Date creationDate, Date expirationDate) {
        this.title = title;
        this.questions = questions;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
