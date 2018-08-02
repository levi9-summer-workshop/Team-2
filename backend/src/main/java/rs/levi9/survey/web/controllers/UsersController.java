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
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<SurveyUser> findAll() {
        return surveyUserService.findAll();
    }

    /**
     * Only admin is allowed to block user
     * Insert value of blocked user
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/users")
    public SurveyUser block(@RequestBody SurveyUser user) {
        return surveyUserService.save(user);
    }

    /**
     * Only admin is allowed to delete user
     * @param id - of selected user
     * @return - delete selected user
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyUserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/user/email")
    public SurveyUser findByEmail(SurveyUser surveyUser){
        return surveyUserService.findByEmail(surveyUser.getEmail());
    }

    @PutMapping(path = "/user/update")
    public ResponseEntity update(SurveyUser surveyUser) {
        if(!surveyUserService.checkIfUserExists(surveyUser)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity(surveyUserService.save(surveyUser), HttpStatus.OK);
        }
    }

}
