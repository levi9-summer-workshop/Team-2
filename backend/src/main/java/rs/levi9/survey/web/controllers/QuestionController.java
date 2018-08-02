package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Question;
import rs.levi9.survey.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question save(@RequestBody Question question) {
        return questionService.save(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.findAll();
    }


}
