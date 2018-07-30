package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.repositories.ChoiceRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class ChoicesService {

    private ChoiceRepository choiceRepository;

    @Autowired
    public ChoicesService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public Choice save(Choice choice) {
        return choiceRepository.save(choice);
    }
}
