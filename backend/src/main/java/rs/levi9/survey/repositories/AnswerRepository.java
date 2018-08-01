package rs.levi9.survey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.domain.Choice;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllBySurveyId(Long id);
    List<Answer> findAllByUserId(Long id);
    List<Answer> findAllByQuestionId(Long id);
    List<Answer> findAllByChoiceEquals(Choice choice);
}
