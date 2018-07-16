package rs.levi9.survey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "question")
public class Question extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String text;

    public Question() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
