package org.asm.labs.dao;

import org.asm.labs.domain.Answer;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("classpath:test.properties")
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