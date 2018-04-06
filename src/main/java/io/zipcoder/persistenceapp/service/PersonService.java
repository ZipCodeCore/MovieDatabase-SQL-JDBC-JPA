package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    JdbcTemplate jdbc;

//    public void addPerson(Person person){
//
//        jdbc.query('INSERT into PERSON values (')
//
//    }

    public Person getPersonById (int personId) {
        String sql = "SELECT * FROM PERSON WHERE ID = ?";
        Person person = (Person)jdbc.queryForObject(sql, new Object[] {personId}, new PersonRowMapper());
        return person;
    }



}
