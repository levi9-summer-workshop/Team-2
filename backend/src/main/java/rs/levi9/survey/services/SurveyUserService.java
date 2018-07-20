package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Role;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.repositories.SurveyUserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service that will communicating with repository
 */

@Transactional
@Service
public class SurveyUserService implements UserDetailsService {

    private SurveyUserRepository surveyUserRepository;

    @Autowired
    public SurveyUserService(SurveyUserRepository surveyUserRepository) {
        this.surveyUserRepository = surveyUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SurveyUser surveyUser = surveyUserRepository.findByUsername(username);
            if (surveyUser == null) {
                return null;
            }
            return new User(surveyUser.getUsername(), surveyUser.getPassword(), getAuthorities(surveyUser));
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(SurveyUser surveyUser){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role : surveyUser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getType().toString());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

    /**
     * Save user in repository
     *
     * @param surveyUser
     * @return
     */
    public SurveyUser save(SurveyUser surveyUser) {
        return surveyUserRepository.save(surveyUser);
    }

    /**
     * Get all users from repository
     *
     * @return
     */
    public List<SurveyUser> findAll() {
        return surveyUserRepository.findAll();
    }

    /**
     * Delete user by id from repository
     * @param id
     */
    public void delete(Long id) {
        surveyUserRepository.delete(id);
    }

    public boolean checkIfUserExists(SurveyUser surveyUser) {
        SurveyUser user1 = surveyUserRepository.findByUsername(surveyUser.getUsername());
        SurveyUser user2 = surveyUserRepository.findByEmail(surveyUser.getEmail());
        return(user1 == null && user2 == null);
    }
}
