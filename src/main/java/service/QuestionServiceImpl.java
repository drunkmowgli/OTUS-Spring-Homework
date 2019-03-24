package service;

import dao.QuestionDao;
import domain.Question;

import java.util.List;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    private final AnswerService answerService;

    public QuestionServiceImpl(QuestionDao questionDao, AnswerService answerService) {
        this.questionDao = questionDao;
        this.answerService = answerService;
    }

    public List<Question> getAll() {
        return questionDao.getAll();
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
