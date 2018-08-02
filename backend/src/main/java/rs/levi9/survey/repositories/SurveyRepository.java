package rs.levi9.survey.repositories;

import antlr.collections.impl.LList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyPrivacy;
import rs.levi9.survey.domain.SurveyStatus;
import rs.levi9.survey.domain.SurveyUser;

import java.util.Date;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findAllBySurveyUserId(Long id);
    List<Survey> findAllByCreationDate (Date creationDate);
    List<Survey> findAllSurveysBySurveyPrivacy (SurveyPrivacy.PrivacyType privacyType);
    List<Survey> findAllByTitleIsContaining (String title);
    List<Survey> findAllBySurveyStatusAndSurveyPrivacy (SurveyStatus.StatusType statusType, SurveyPrivacy.PrivacyType privacyType);

}
