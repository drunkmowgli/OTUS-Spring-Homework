package dao;

import domain.Answer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnswerDaoImplTest {

    @Test
    public void getAll() {
        String fileName = "AnswersTest.csv";
        AnswerDao answerDao = new AnswerDaoImpl(fileName);
        List<Answer> answerList = answerDao.getAll();
        assertEquals(2, answerList.size());
        assertEquals("0", answerList.get(0).getId());
        assertEquals("988", answerList.get(0).getAnswer());
    }
}