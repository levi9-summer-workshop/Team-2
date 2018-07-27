package rs.levi9.survey.domain;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    private String creator;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


    public String getTitle() {
        return title;
    }

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
