package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.AnswerService;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerService answerService;
    private SurveyUserService surveyUserService;

    @Autowired
    public AnswerController(AnswerService answerService, SurveyUserService surveyUserService) {
        this.answerService = answerService;
        this.surveyUserService = surveyUserService;
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
    public ResponseEntity save(@RequestBody List<Answer> answers) {
        for(Answer answer: answers) {
            SurveyUser surveyUser = new SurveyUser();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            surveyUser = surveyUserService.findByUsername(currentPrincipalName);
            if(surveyUser != null) {
                System.out.println(currentPrincipalName);
                answer.setUser(surveyUser);
                System.out.println(surveyUser);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            answerService.save(answer);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
