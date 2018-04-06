package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    public List<Person> getAllPerson () {
        String sql = "SELECT * FROM PERSON";
        List<Person> people = new ArrayList<>();
       List<Map<String,Object>> rows = jdbc.queryForList(sql);
       for(Map row : rows) {
           Person person = new Person();
           person.setId((int)row.get("ID"));
           person.setFirstName((String)row.get("FIRST_NAME"));
           person.setLastName((String)row.get("LAST_NAME"));
           person.setMobile((String)row.get("MOBILE"));
           person.setBirthday((Date)row.get("BIRTHDAY"));
           person.setHomeId((short)row.get("HOME_ID"));
           people.add(person);

       }

       return people;
    }



}
