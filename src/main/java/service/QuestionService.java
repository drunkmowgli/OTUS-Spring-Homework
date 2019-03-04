package service;

import domain.Question;

import java.util.List;

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

}
