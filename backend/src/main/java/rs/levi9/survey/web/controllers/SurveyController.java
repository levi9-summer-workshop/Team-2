package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Survey;

import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyServices;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private SurveyServices surveyServices;

    @Autowired
    public SurveyController(SurveyServices surveyServices) {
        this.surveyServices = surveyServices;
    }

    @PostMapping
    public Survey save(@RequestBody Survey survey) {
        return surveyServices.save(survey);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Survey>> findAll() {
        List<Survey> surveys = surveyServices.findAll();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyServices.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
