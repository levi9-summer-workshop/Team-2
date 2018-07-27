package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Survey;

import rs.levi9.survey.services.SurveyServices;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private SurveyServices surveyServices;
    private SurveyUserService surveyUserService;

    @Autowired
    public SurveyController(SurveyServices surveyServices, SurveyUserService surveyUserService) {
        this.surveyServices = surveyServices;
        this.surveyUserService = surveyUserService;
    }

    @PostMapping
    public Survey save(@RequestBody Survey survey) {
        return surveyServices.save(survey);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Survey>> findAll() {
        List<Survey> surveys = surveyServices.findAll();
        for(int i = 0; i < surveys.size(); i++) {
            Survey survey = surveys.get(i);
            surveys.set(i, survey);
        }

        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }
}
