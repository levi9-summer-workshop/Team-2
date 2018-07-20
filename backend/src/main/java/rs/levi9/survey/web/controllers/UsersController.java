package rs.levi9.survey.web.controllers;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping
    public SurveyUser block(@RequestBody SurveyUser user) {
        return surveyUserService.save(user);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyUserService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody SurveyUser surveyUser) {
        if(surveyUserService.checkIfUserExists(surveyUser)) {
            return new ResponseEntity(surveyUserService.save(surveyUser), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
