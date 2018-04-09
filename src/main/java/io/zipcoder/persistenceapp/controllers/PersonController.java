package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.services.PersonService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController implements PersonService{


    @Override
    public void addPerson() {

    }

    @Override
    public void updateExistingPerson() {

    }

    @Override
    public void removePerson() {

    }

    @Override
    public void removeListOfPeople() {

    }

    @Override
    public List<Person> findPeopleWithFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Person> findPeopleWithLastName(String lastName) {
        return null;
    }

    @Override
    public List<Person> findPeopleWithBirthday(String birthday) {
        return null;
    }

    @Override
    public Person findPersonWithId() {
        return null;
    }
}
