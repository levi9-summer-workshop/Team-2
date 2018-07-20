package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyUserService;

import java.util.List;

/**
 * Controller where are CRUD operations and few more that will be added
 */

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private SurveyUserService surveyUserService;

    @Autowired
    public UsersController(SurveyUserService surveyUserService) {
        this.surveyUserService = surveyUserService;
    }

    /**
     * Only admin is allowed to see all users
     * @return - value of all users
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<SurveyUser> findAll() {
        return surveyUserService.findAll();
    }

    /**
     * Only admin is allowed to block user
     * Insert value of blocked user
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public SurveyUser block(@RequestBody SurveyUser user) {
        return surveyUserService.save(user);
    }

    /**
     * Only admin is allowed to delete user
     * @param id - of selected user
     * @return - delete selected user
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyUserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
