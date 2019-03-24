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

    /**
     * Returns <int>count</int> of correct person's answers.
     *
     * @param personAnswerMap - Person's answers
     * @return <int>count</int> of correct person's answers
     */

    int countCorrectAnswer(Map<String, String> personAnswerMap);

}
