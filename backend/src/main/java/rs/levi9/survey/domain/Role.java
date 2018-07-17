package rs.levi9.survey.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    private RoleType type;

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public enum RoleType {
        ROLE_USER, ROLE_ADMIN
    }
}
