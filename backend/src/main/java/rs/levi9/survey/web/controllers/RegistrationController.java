package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Role;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyUserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Controller for registration with method that check if user exist
 */

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private SurveyUserService surveyUserService;

    @Autowired
    public RegistrationController(SurveyUserService surveyUserService) {
        this.surveyUserService = surveyUserService;
    }

    /**
     * User registration
     *
     * @param surveyUser - that wants to be registered
     * @return
     */
    @PostMapping
    public ResponseEntity registration(@RequestBody SurveyUser surveyUser) {
        if(surveyUserService.checkIfUserExists(surveyUser)) {
            // If not exist insert into database
            surveyUserService.setRole(surveyUser, 2l, Role.RoleType.ROLE_USER);
            return new ResponseEntity(surveyUserService.save(surveyUser), HttpStatus.OK);
        }
        else {
            // If exist send HttpStatus 400(Bad request)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}