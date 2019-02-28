package service;

import dao.AnswerDao;
import dao.AnswerDaoImpl;
import domain.Answer;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerServiceImplTest {

    @Test
    public void getAll() {

        AnswerDao answerDao = mock(AnswerDaoImpl.class);
        when(answerDao.getAll()).thenReturn(Collections.singletonList(
                new Answer("1", "988")));
        AnswerService answerService = new AnswerServiceImpl(answerDao);
        List<Answer> answerList = answerService.getAll();
        assertEquals(1, answerList.size());
        assertEquals("1", answerList.get(0).getId());
        assertEquals("988", answerList.get(0).getAnswer());

    }

    @Test
    public void compareAnswer() {
        String personAnswer = "иЗя";
        Answer answer = new Answer("1", "Изя");
        assertTrue(personAnswer.equalsIgnoreCase(answer.getAnswer()));
    }
}