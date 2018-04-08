package io.zipcoder.persistenceapp.services;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonService {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void addPerson() {

    }

    public void updateExistingPerson() {

    }

    public void removePerson() {

    }

    public void removeListOfPeople() {

    }

    public void findPeopleWithFirstName() {

    }

    public void findPeopleWithLastName() {

    }

    public void findPeopleWithBirthdate() {

    }

    public void findPersonWithId() {

    }

    public void generateMapLastNameList() {
        // return map<lastName, List<firstName of people with that lastName>>
    }

    public void generateMapFirstNameOccurrences() {
        // return map<firstName, int occurrences>
    }

}
