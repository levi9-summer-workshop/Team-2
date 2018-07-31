package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.services.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public ResponseEntity<List<Answer>> findAll() {
        List<Answer> answerList = answerService.findAll();

        if(answerList != null) {
            return new ResponseEntity<>(answerList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody List<Answer> answers) {
        for(Answer answer: answers) {
           answerService.save(answer);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
