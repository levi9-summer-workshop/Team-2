package rs.levi9.survey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "choices")
public class Choice extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String choice;

    private Long result = 0L;

    public Choice() {

    }

    public Choice(String choice, Long result) {
        this.choice = choice;
        this.result = result;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public Choice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

}
