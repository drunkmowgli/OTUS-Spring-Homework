package dao;

import domain.Question;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionDaoImplTest {

    @Test
    public void getAll() {
        String fileName = "QuestionsTest.csv";
        QuestionDao questionDao = new QuestionDaoImpl(fileName);
        List<Question> questionList = questionDao.getAll();
        assertEquals(2, questionList.size());
        assertEquals("0", questionList.get(0).getId());
        assertEquals("Назовите год крещения Руси", questionList.get(0).getQuestion());
    }
}