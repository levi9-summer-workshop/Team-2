package rs.levi9.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.levi9.survey.domain.Answer;
import rs.levi9.survey.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository surveyRepository) {
        this.answerRepository = surveyRepository;
    }

    public Answer findOne(Long id) {
        return answerRepository.findOne(id);
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public void delete(Long id) {
        answerRepository.delete(id);

    }
}