package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.repositories.SurveyRepository;

import javax.transaction.Transactional;
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

    public List<Survey> findAll(){
       return this.surveyRepository.findAll();
    }
}
