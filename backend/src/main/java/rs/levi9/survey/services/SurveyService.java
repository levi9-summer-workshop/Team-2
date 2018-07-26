package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.repositories.SurveyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SurveyService {

    private SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public Survey findOne(Long id) {
        return surveyRepository.findOne(id);
    }

    @Transactional
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Transactional
    public void delete(Long id) {
        surveyRepository.delete(id);
    }
}
