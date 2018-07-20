package rs.levi9.survey.web.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.levi9.survey.domain.AuthenticatedUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for login that only have one method for user authentication
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @RequestMapping("/login")
    public AuthenticatedUser getUser(Authentication authentication) {

        List<String> roles = new ArrayList<>();
        for(GrantedAuthority authority : authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        AuthenticatedUser user = new AuthenticatedUser(authentication.getName(), roles);
        return user;
        }
    }

