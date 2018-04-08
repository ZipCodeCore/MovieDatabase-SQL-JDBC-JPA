package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequestMapping
public class PersonService {

    JdbcTemplate template;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity createPerson(Integer id, String first_name, String last_name, String mobile, String birthday, Integer home_id){
        String sql = "INSERT INTO people (ID, FIRST_NAME, LAST_NAME, MOBILE, BIRTHDAY, HOME_ID) VALUES (" + id + ", " + first_name + ", " + last_name + ", "
                + mobile + ", " + birthday + ", " + home_id + ")";
        Person person = new Person(id, first_name, last_name, mobile, birthday, home_id);
        template.execute(sql);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity getAllPeople(){
        String sql = "SELECT * FROM person";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }
}
