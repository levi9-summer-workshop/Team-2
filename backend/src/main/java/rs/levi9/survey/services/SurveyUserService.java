package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.repositories.SurveyUserRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class SurveyUserService {
    private SurveyUserRepository surveyUserRepository;

    @Autowired
    public SurveyUserService(SurveyUserRepository surveyUserRepository) {
        this.surveyUserRepository = surveyUserRepository;
    }

    public SurveyUser save(SurveyUser surveyUser) {
        return surveyUserRepository.save(surveyUser);
    }
}
