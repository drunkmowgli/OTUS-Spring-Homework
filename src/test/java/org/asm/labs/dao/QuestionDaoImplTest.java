package org.asm.labs.dao;

import org.asm.labs.domain.Question;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionDaoImplTest {

    @Test
    public void getAll() {
        String fileNameEN = "QuestionsTestEN.csv";
        String fileNameRU = "QuestionsTestRU.csv";
        QuestionDao questionDao = new QuestionDaoImpl(fileNameEN, fileNameRU);
        Locale locale = Locale.getDefault();
        List<Question> questionList = questionDao.getAll(locale);
        assertEquals(2, questionList.size());
        assertEquals("0", questionList.get(0).getId());
        assertEquals("Назовите год крещения Руси", questionList.get(0).getQuestion());
    }

}