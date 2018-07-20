package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<SurveyUser> findAll() {
        return surveyUserService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public SurveyUser block(@RequestBody SurveyUser user) {
        return surveyUserService.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyUserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
