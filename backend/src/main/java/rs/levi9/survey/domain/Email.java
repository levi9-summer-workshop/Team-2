package rs.levi9.survey.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
public class Email extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    private EmailType emailType;

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public enum EmailType {
        REGISTRATION, SURVEY_ANSWERED
    }
}
