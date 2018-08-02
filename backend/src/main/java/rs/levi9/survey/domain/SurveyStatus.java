package rs.levi9.survey.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties
public class SurveyStatus extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusType statusType;

    public SurveyStatus() {
    }

    public SurveyStatus(StatusType statusType) {
        this.statusType = statusType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public static enum StatusType {
        OPEN, CLOSE
    }
}
