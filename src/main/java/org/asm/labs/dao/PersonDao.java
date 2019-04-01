package org.asm.labs.dao;

import org.asm.labs.domain.Person;

/**
 * @author Yuriy Maslov
 */

public interface PersonDao {

    /**
     * Returns the Person by the Name.
     *
     * @param name - Name of Person
     * @return Person
     */

    Person findByName(String name);

}
