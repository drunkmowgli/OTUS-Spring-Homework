package service;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExamServiceImplTest {

    @Test
    public void countCorrectAnswer() {
        AnswerService answerService = mock(AnswerService.class);
        ExamService examService = new ExamServiceImpl(answerService);
        String questionId = "0";
        String personAnswer = "988";
        Map<String, String> personAnswerMap = new HashMap<>();
        personAnswerMap.put(questionId, personAnswer);
        when(answerService.isCorrectAnswer(questionId, personAnswer)).thenReturn(true);
        assertEquals(1, examService.countCorrectAnswer(personAnswerMap));
    }
}