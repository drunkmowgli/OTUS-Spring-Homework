package service;

import domain.Question;

import java.util.List;
import java.util.Map;

/**
 * @author Yuriy Maslov
 */
public interface QuestionService {

    /**
     * Returns List of Questions.
     *
     * @return List of Questions
     */
    List<Question> getAll();

    int countCorrectAnswer(Map<String, String> personAnswerMap);

}
