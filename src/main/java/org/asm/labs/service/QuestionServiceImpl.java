package org.asm.labs.service;

import org.asm.labs.dao.QuestionDao;
import org.asm.labs.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    private final AnswerService answerService;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao, AnswerService answerService) {
        this.questionDao = questionDao;
        this.answerService = answerService;
    }

    public List<Question> getAll(Locale locale) {
        return questionDao.getAll(locale);
    }

    public int countCorrectAnswer(Map<String, String> personAnswerMap) {

        int count = 0;

        for (Map.Entry<String, String> entry : personAnswerMap.entrySet()) {

            if (answerService.isCorrectAnswer(entry.getKey(), entry.getValue())) {
                count++;
            }

        }

        return count;
    }
}
