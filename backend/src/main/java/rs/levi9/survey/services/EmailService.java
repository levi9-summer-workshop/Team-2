package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Email;
import rs.levi9.survey.domain.SurveyUser;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendEmail(SurveyUser surveyUser, Email.EmailType emailType) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(surveyUser.getEmail());
        switch(emailType){
            case REGISTRATION:
                 helper.setSubject("Registration");
                 helper.setText("Hi " + surveyUser.getUsername() + "!\nYou have registered to our OnlineSurvey application!\nThank you for being awesome!");
            break;
            case SURVEY_ANSWERED:
                helper.setSubject("Survey Answered");
                helper.setText("Thank you for answering a Survey!");
        }
        emailSender.send(message);
    }

}
