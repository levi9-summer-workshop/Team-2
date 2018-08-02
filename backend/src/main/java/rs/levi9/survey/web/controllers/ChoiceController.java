package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.services.ChoiceService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("choices")
@CrossOrigin(origins = "http://localhost:4200")
public class ChoiceController {

    private ChoiceService choiceService;

    @Autowired

    public ChoiceController(ChoiceService choiceService) {
        this.choiceService = choiceService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping
    public ResponseEntity findAllChoices() {
        List<Choice> choiceList = this.choiceService.findAll();
        if(choiceList == null) {
            return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(choiceList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity submitResult(@RequestBody List<Choice> choices) {
        System.err.println(choices);
        if(!choices.isEmpty()){
            for (Choice choice : choices) {
                Choice choice1;
                try {
                    String text1 = choice.getText();
                    choice1 = choiceService.findChoiceByText(text1);
                }catch(NoSuchElementException e){
                    e.printStackTrace();
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
                Long result1 = choice1.getResult();
                result1++;
                choice1.setResult(result1);
                choiceService.save(choice1);
            }
        }else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}