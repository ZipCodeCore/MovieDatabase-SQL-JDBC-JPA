package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PersonService {

    // What's this for again
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    void addPerson();

    void updateExistingPerson();

    void removePerson();

    void removeListOfPeople();

    List<Person> findPeopleWithFirstName(String firstName);

    List<Person> findPeopleWithLastName(String lastName);

    List<Person> findPeopleWithBirthday(String birthday);

    Person findPersonWithId();

}
