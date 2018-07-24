package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.AuthenticatedUser;
import rs.levi9.survey.services.SurveyUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for login that only have one method for user authentication
 */

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private SurveyUserService surveyUserService;

    @Autowired
    public LoginController(SurveyUserService surveyUserService) {
        this.surveyUserService = surveyUserService;
    }

    @RequestMapping
    public AuthenticatedUser getUser(Authentication authentication) {

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        AuthenticatedUser user = new AuthenticatedUser(authentication.getName(), roles);

        if(surveyUserService.isBlocked(user)) {

            return user;
        } else {
            return null;
        }
    }
}

