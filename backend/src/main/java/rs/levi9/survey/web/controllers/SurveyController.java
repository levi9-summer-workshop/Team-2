package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.services.SurveyService;

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public Survey save(@RequestBody Survey survey) {
        return surveyService.save(survey);
    }
}
