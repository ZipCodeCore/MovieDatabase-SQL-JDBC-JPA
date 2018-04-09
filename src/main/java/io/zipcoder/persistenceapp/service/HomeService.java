package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Person;

import java.util.List;

public interface HomeService {

    List<Person> getAllPeople();

    void deletePerson(int id);

    void deletePeople(List<Person> cars);

    void addPerson(Person person);

    Person findById(int id);
}
