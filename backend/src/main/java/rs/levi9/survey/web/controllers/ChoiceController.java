package rs.levi9.survey.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.services.ChoicesService;

import java.util.List;

@RestController
@RequestMapping("/choices")
@CrossOrigin(origins = "http://localhost:4200")
public class ChoiceController {

    private ChoicesService choicesService;

    @Autowired
    public ChoiceController(ChoicesService choicesService) {
        this.choicesService = choicesService;
    }

    @PostMapping
    public Choice save(@RequestBody Choice choice) {
        return choicesService.save(choice);
    }

    @GetMapping
    public List<Choice> getAll() {
        return choicesService.findAll();
    }
}
