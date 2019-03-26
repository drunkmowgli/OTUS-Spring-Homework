package org.asm.labs.dao;

import org.asm.labs.domain.Question;

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
