package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Question;
import rs.levi9.survey.repositories.QuestionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findOne(Long questionId) {
        return questionRepository.findOne(questionId);
    }

    @Transactional
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Transactional
    public void delete(Long questionId) {
        questionRepository.delete(questionId);
    }
}
