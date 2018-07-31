package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyUser;

import java.util.Date;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findAllByCreationDate (Date creationDate);

}
