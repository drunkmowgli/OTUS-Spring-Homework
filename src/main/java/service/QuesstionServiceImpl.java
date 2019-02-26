package service;

import dao.QuestionDao;
import domain.Question;

import java.util.List;

public class QuesstionServiceImpl implements QuesstionService {

    private final QuestionDao questionDao;

    public QuesstionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getAll() {
        return questionDao.getAll();
    }
}
