package service;

import domain.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAll();

    boolean compareAnswer(String personAnswer, Answer answer);

}
