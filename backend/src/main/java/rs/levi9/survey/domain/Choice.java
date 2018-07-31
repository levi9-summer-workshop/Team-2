package rs.levi9.survey.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "choices")
public class Choice extends BaseEntity {

    @Column
    private String choice;

    public Choice() {}

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
