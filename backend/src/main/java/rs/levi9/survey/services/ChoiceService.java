package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.repositories.ChoiceRepository;

import java.util.List;

@Transactional
@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository){
        this.choiceRepository = choiceRepository;
    }

    public List<Choice> findAll(){
        return choiceRepository.findAll();
    }

    public List<Choice> findAllByChoice (List<Choice> choices){
        return choiceRepository.findAllByChoice(choices);
    }

    public Choice findOne(Long id) {
        return choiceRepository.findOne(id);
    }

    public Choice save(Choice choice) {
        return choiceRepository.save(choice);
    }

    public Choice update (Choice choice) {
        return choiceRepository.save(choice);
    }


}
