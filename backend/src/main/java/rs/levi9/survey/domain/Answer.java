package rs.levi9.survey.domain;

import javax.persistence.Entity;

@Entity
public class Answer extends BaseEntity {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
