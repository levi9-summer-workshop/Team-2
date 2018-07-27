package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.repositories.SurveyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SurveyService {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public Survey findOne(Long surveyId) {
        return surveyRepository.findOne(surveyId);
    }


    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    public void delete(Long surveyId) {
        surveyRepository.delete(surveyId);
    }


}