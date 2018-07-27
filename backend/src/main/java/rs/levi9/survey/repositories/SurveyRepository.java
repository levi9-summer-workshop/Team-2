package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.levi9.survey.domain.Survey;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
