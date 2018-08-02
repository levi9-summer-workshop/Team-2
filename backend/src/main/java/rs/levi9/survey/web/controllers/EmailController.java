package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Email;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.domain.SurveyUser;
import rs.levi9.survey.services.EmailService;
import javax.mail.MessagingException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping("/email/registration")
    public ResponseEntity sendRegistrationEmail(@RequestBody SurveyUser surveyUser) {
//        SurveyUser surveyUser1 = new SurveyUser();
//        surveyUser1 = surveyUser;
        try {
            emailService.sendEmail(surveyUser,Email.EmailType.REGISTRATION);
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Message sent!", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping("/email/survey_answered")
    public ResponseEntity sendSurveyAnsweredEmail(@RequestBody SurveyUser surveyUser) {
        try {
            emailService.sendEmail(surveyUser,Email.EmailType.SURVEY_ANSWERED);
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Message sent!", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping("/email/invitation")
    public ResponseEntity sendSurveyInvitationEmail(@RequestBody SurveyUser surveyUser) {
        try {
            emailService.sendEmail(surveyUser,Email.EmailType.SURVEY_ANSWERED);
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Message sent!", HttpStatus.OK);
    }
}
