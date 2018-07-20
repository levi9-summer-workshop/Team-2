package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyUserService;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private SurveyUserService surveyUserService;

    @Autowired
    public RegistrationController(SurveyUserService surveyUserService) {
        this.surveyUserService = surveyUserService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody SurveyUser surveyUser) {
        if(surveyUserService.checkIfUserExists(surveyUser)) {
            return new ResponseEntity(surveyUserService.save(surveyUser), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
