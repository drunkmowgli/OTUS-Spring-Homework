package org.asm.labs.service;

import org.asm.labs.dao.PersonDao;
import org.asm.labs.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getByName(String name) {
        return personDao.findByName(name);
    }
}
