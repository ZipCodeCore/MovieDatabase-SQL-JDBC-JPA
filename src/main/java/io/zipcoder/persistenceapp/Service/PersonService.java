package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

//    private SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    /**
     * SQL methods needed:
     * Add
     * Update
     * Remove
     * Remove a list of people
     * Find single person by ID
     * Generate a map of lastnames to list people with that lastname
     * Generate a map of firstnames to the number of occurrences.
     */
    private static final String addPerson = "INSERT INTO PERSON " +
            "(firstName, lastName, mobileNumber, birthDate, homeId, id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String updatePerson = "UPDATE PERSON SET ";
    private static final String getAllPersons = "SELECT * FROM PERSON";
    private static final String getSingleId = "SELECT * FROM PERSON WHERE ID = ?";
    private static final String getAllIds = "SELECT ID FROM PERSON";
    private static final String deletePerson = "DELETE * FROM PERSON WHERE ID = ?";
    private static final String deleteListPerson = "";
    private static final String getMapLastName = "";
    private static final String getMapFirstName = "";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person getSinglePersonById(int id){
        Person person = (Person)jdbcTemplate.queryForObject(getSingleId, new Object[] {id}, new PersonRowMapper());
        return person;
    }
//    public void addPerson(Person person){
//        jdbcTemplate.update(addPerson, new Object[]
//                {person.getFirstName(), person.getLastName(), person.getMobileNumber(), person.getBirthDate(), person.getHomeId(), person.getId()});
//    }

}
