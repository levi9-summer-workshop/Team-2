package rs.levi9.survey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "choices")
public class Choice extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String text;

    private Long result = 0L;

    public Choice() {

    }

    public Choice(String text, Long result) {
        this.text = text;
        this.result = result;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
