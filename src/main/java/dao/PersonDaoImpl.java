package dao;

import domain.Person;

public class PersonDaoImpl implements PersonDao {

    public Person findByName(String name) {
        return new Person(name);
    }
}
