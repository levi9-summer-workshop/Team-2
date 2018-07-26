package rs.levi9.survey.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Question;
import rs.levi9.survey.domain.Survey;
import rs.levi9.survey.services.QuestionService;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


}
