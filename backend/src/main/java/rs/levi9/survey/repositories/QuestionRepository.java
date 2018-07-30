package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Question;
import rs.levi9.survey.domain.SurveyUser;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
