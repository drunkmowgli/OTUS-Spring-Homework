package service;

import dao.AnswerDao;
import domain.Answer;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {

    private final AnswerDao answerDao;

    public AnswerServiceImpl(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public List<Answer> getAll() {
        return answerDao.getAll();
    }


    public boolean compareAnswer(String personAnswer, Answer answer) {

        return personAnswer.equalsIgnoreCase(answer.getAnswer());

    }

}
