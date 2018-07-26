package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.SurveyUser;


@Repository
public interface SurveyUserRepository extends JpaRepository<SurveyUser, Long> {

    SurveyUser findByUsername(String username);
    SurveyUser findByEmail(String email);

    /**
     * Custom query for finding the username in database
     * and see if it't blocked or not.
     *
     * @param username
     * @return
     */
    @Query(value = "SELECT blocked from user where username=:username", nativeQuery=true)
    String getBlockedInformation(@Param("username") String username);
}
