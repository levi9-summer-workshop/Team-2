package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyPrivacy;
import rs.levi9.survey.domain.SurveyStatus;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.SurveyServices;
import rs.levi9.survey.services.SurveyUserService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyController {

    private SurveyServices surveyServices;
    private SurveyUserService surveyUserService;

    @Autowired
    public SurveyController(SurveyServices surveyServices, SurveyUserService surveyUserService) {
        this.surveyServices = surveyServices;
        this.surveyUserService = surveyUserService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public Survey save(@RequestBody Survey survey) {
        Date date = new Date();
        survey.setCreationDate(date);
        return surveyServices.save(survey);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Survey>> findAll() {
        List<Survey> surveys = surveyServices.findAll();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") Long id) { Survey survey = surveyServices.findOne(id);

        if(survey == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(survey, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        surveyServices.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(path = "/public")
    public ResponseEntity findAllPublicSurveys() {
        List<Survey> publicSurveys = surveyServices.findAllPublicSurveys();
        if(publicSurveys == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity(publicSurveys, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping(path = "/set-public")
    public ResponseEntity setSurveyPublic(@RequestBody Survey survey) {
        if(survey != null){
            surveyServices.setPrivacy(survey, 1l, SurveyPrivacy.PrivacyType.PUBLIC);
            surveyServices.save(survey);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping(path = "/set-private")
    public ResponseEntity setSurveyPrivate(@RequestBody Survey survey) {
        if(survey != null){
            surveyServices.setPrivacy(survey, 2l, SurveyPrivacy.PrivacyType.PRIVATE);
            surveyServices.save(survey);
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PreAuthorize(("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"))
    @RequestMapping(path = "/public/open")
    public ResponseEntity findAllPublicAndOpenSurveys() {
        List<Survey> publicOpenSurveys = surveyServices.findAllPublicSurveysBySurveyStatus(SurveyStatus.StatusType.OPEN);
        if (publicOpenSurveys == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(publicOpenSurveys, HttpStatus.OK);
        }
    }


    @PreAuthorize(("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')"))
    @RequestMapping(path = "/public/close")
    public ResponseEntity findAllPublicAndCloseSurveys() {
        List<Survey> publicCloseSurveys = surveyServices.findAllPublicSurveysBySurveyStatus(SurveyStatus.StatusType.CLOSE);
        if (publicCloseSurveys == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
                return new ResponseEntity(publicCloseSurveys, HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping(path = "/user/id")
    public List<Survey> findAllBySurveyUser() {
        SurveyUser surveyUser = surveyUserService.getLoggedInSurveyUser();
        return surveyServices.findAllBySurveyUserId(surveyUser.getId());
    }

}
