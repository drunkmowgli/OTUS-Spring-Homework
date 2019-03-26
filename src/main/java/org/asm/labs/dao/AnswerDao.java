package org.asm.labs.dao;

import org.asm.labs.domain.Answer;

import java.util.List;

/**
 * @author Yuriy Maslov
 */

public interface AnswerDao {

    /**
     * Returns the List of the Answers.
     *
     * @return the List of the Answers
     */

    List<Answer> getAll();

}
