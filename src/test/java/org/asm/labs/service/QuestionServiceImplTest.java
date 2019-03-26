package org.asm.labs.service;

import org.asm.labs.dao.QuestionDao;
import org.asm.labs.dao.QuestionDaoImpl;
import org.asm.labs.domain.Question;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceImplTest {

    @Test
    public void getAll() {

        QuestionDao questionDao = mock(QuestionDaoImpl.class);
        AnswerService answerService = mock(AnswerServiceImpl.class);
        when(questionDao.getAll()).thenReturn(Collections.singletonList(
                new Question("1","Назовите год крещения Руси")));
        QuestionService questionService = new QuestionServiceImpl(questionDao, answerService);
        List<Question> questionList = questionService.getAll();
        assertEquals(1, questionList.size());
        assertEquals("1", questionList.get(0).getId());
        assertEquals("Назовите год крещения Руси", questionList.get(0).getQuestion());

    }
}