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


    public boolean isCorrectAnswer(String questionId, String personAnswer) {

        String correctAnswer = answerDao.getAll().get(Integer.parseInt(questionId)).getAnswer();

        return personAnswer.equalsIgnoreCase(correctAnswer);

    }

}
