package org.asm.labs.service;

import org.asm.labs.dao.AnswerDao;
import org.asm.labs.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerDao answerDao;

    @Autowired
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
