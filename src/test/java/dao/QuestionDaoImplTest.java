package dao;

import domain.Question;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class QuestionDaoImplTest {

    @Test
    public void getAll() {
        String fileName = "QuestionsTest.csv";
        QuestionDao questionDao = new QuestionDaoImpl(fileName);
        List<Question> questionList = questionDao.getAll();
        assertEquals(1, questionList.size());
        assertEquals("Назовите год крещения Руси", questionList.get(0).getQuestion());
    }
}