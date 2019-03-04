package service;

import dao.QuestionDao;
import domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getAll() {
        return questionDao.getAll();
    }
}
