package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyPrivacy;
import rs.levi9.survey.domain.SurveyStatus;
import rs.levi9.survey.repositories.SurveyRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class SurveyServices {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyServices(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey save(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> findAll() {
        return this.surveyRepository.findAll();
    }
  
    public Survey findOne(Long id) {
        return surveyRepository.findOne(id);
    }
  
    public void delete(Long id) {
        surveyRepository.delete(id);
    }

    public List<Survey> findAllByCreationDate (Date date){
        return surveyRepository.findAllByCreationDate(date);
    }

    public List<Survey> findAllPublicSurveys() {
        return surveyRepository.findAllSurveysBySurveyPrivacy(SurveyPrivacy.PrivacyType.PUBLIC);
    }

    public List<Survey> findAllPrivateSurveys() {
        return surveyRepository.findAllSurveysBySurveyPrivacy(SurveyPrivacy.PrivacyType.PRIVATE);
    }

    public void setSurveyPrivacy(Long id, SurveyPrivacy.PrivacyType privacyType) {
        Survey survey = findOne(id);
        SurveyPrivacy surveyPrivacy = new SurveyPrivacy(privacyType);
    }

    public List<Survey> findAllByTitleIsContaining (String title) {
        return surveyRepository.findAllByTitleIsContaining(title);
    }

    public List<Survey> findAllPublicSurveysBySurveyStatus (SurveyStatus.StatusType statusType){
      return surveyRepository.findAllBySurveyStatusAndSurveyPrivacy(statusType, SurveyPrivacy.PrivacyType.PUBLIC);
    }

}
