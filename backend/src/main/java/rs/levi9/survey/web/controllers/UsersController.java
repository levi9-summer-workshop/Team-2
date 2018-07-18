package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private SurveyUserService surveyUserService;

    @Autowired
    public UsersController(SurveyUserService surveyUserService) {
        this.surveyUserService = surveyUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SurveyUser> findAll() {
        return surveyUserService.findAll();
    }
}
