package rs.levi9.survey.domain;


import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class SurveyUser extends BaseEntity implements Serializable {

    @Length(min = 5)
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Length(min = 5)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean blocked = false;
  
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Survey> surveys;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
