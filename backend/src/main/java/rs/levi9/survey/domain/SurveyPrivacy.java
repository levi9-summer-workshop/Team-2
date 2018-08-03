package rs.levi9.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SurveyPrivacy extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrivacyType privacyType;

    public SurveyPrivacy(){
    }

    public SurveyPrivacy(PrivacyType privacyType) {
        this.privacyType = privacyType;
    }

    public PrivacyType getPrivacyType() {
        return privacyType;
    }

    public void setPrivacyType(PrivacyType privacyType) {
        this.privacyType = privacyType;
    }

    public static enum PrivacyType {
        PUBLIC, PRIVATE
    }
}
