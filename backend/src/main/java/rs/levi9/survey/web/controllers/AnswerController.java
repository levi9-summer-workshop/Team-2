package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.AnswerService;
import rs.levi9.survey.services.SurveyServices;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerService answerService;
    private SurveyUserService surveyUserService;
    private SurveyServices surveyServices;

    @Autowired
    public AnswerController(AnswerService answerService, SurveyUserService surveyUserService, SurveyServices surveyServices) {
        this.answerService = answerService;
        this.surveyUserService = surveyUserService;
        this.surveyServices = surveyServices;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        List<Answer> answerList = answerService.findAll();

        if(answerList != null) {
            return new ResponseEntity<>(answerList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody List<Answer> answers, Long surveyId) {

        for(Answer answer: answers) {
           SurveyUser surveyUser = surveyUserService.getLoggedInSurveyUser();
            if(surveyUser == null && surveyUser.getUsername().equals(answer.getUser())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                answer.setUser(surveyUser);
                answer.setSurvey(surveyServices.findOne(surveyId));
            }
            answerService.save(answer);
            

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
