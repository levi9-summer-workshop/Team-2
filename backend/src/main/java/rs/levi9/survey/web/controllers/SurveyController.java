package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Survey;

import rs.levi9.survey.services.SurveyServices;

import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private SurveyServices surveyServices;

    @Autowired
    public SurveyController(SurveyServices surveyServices) {
        this.surveyServices = surveyServices;
    }

    @PostMapping
    public Survey save(@RequestBody Survey survey){

        return surveyServices.save(survey);
    }

    @GetMapping
    public List<Survey> getAll() {
        return surveyServices.findAll();
    }
}
