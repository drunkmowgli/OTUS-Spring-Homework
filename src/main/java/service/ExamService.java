package service;

import java.util.Map;

/**
 * @author Yuriy Maslov
 */

public interface ExamService {

    /**
     * Returns the number of correct answers.
     *
     * @param personAnswerMap - person's answer
     * @return the number of correct answers
     */
    int countCorrectAnswer(Map<String, String> personAnswerMap);

}
