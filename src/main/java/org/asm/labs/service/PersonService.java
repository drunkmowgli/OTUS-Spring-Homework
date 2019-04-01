package org.asm.labs.service;

import org.asm.labs.domain.Person;

/**
 * @author Yuriy Maslov
 */
public interface PersonService {

    /**
     * Returns Person by Name.
     *
     * @param name Person's name
     * @return Person
     */
    Person getByName(String name);

}
