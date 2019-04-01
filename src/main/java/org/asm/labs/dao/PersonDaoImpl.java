package org.asm.labs.dao;

import org.asm.labs.domain.Person;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    public Person findByName(String name) {
        return new Person(name);
    }
}
