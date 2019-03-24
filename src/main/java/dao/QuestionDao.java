package dao;

import domain.Question;

import java.util.List;

/**
 * @author Yuriy Maslov
 */

public interface QuestionDao {

    /**
     * Returns the List of the Questions.
     *
     * @return the List of the Questions
     */

    List<Question> getAll();

}
