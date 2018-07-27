package rs.levi9.survey.domain;

<<<<<<< Updated upstream

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
=======
import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

>>>>>>> Stashed changes
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey extends BaseEntity implements Serializable {

    @Column
    private String title;

    @Column
    private String showTitle = "true";

<<<<<<< Updated upstream
    @Cascade(CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "survey_id")
    private List<Question> questions;

    public String getTitle() {
        return title;
    }

=======
    @Column
    @OneToMany(mappedBy = "survey")
    private List<Question> questions;

    @Column
    private String creator;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Survey() {
    }

    public Survey(String title, String showTitle, List<Question> questions, String creator, Date creationDate, Date expirationDate) {
        this.title = title;
        this.showTitle = showTitle;
        this.questions = questions;
        this.creator = creator;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public String getTitle() {
        return title;
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

>>>>>>> Stashed changes
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
