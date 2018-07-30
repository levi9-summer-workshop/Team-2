package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Choice;
import rs.levi9.survey.domain.Question;
import rs.levi9.survey.repositories.ChoiceRepository;
import rs.levi9.survey.repositories.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private ChoiceRepository choiceRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository,
                           ChoiceRepository choiceRepository) {
        this.questionRepository = questionRepository;
        this.choiceRepository = choiceRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findOne(Long questionId) {
        return questionRepository.findOne(questionId);
    }


    public Question save(Question question) {

        return questionRepository.save(question);
    }

    public void delete(Long questionId) {
        questionRepository.delete(questionId);
    }
}
