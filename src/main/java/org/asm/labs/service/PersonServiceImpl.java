package org.asm.labs.service;

import org.asm.labs.dao.PersonDao;
import org.asm.labs.domain.Person;

public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getByName(String name) {
        return personDao.findByName(name);
    }
}
