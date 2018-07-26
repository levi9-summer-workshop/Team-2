package rs.levi9.survey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.repositories.AnswerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer findOne(Long id) {
        return answerRepository.findOne(id);
    }

    @Transactional
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Transactional
    public void delete(Long id){
        answerRepository.delete(id);
    }
}
