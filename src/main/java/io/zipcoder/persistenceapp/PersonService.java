package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequestMapping
public class PersonService {

    private JdbcTemplate template;

    public PersonService(JdbcTemplate template) {
        this.template = template;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity createPerson(@RequestBody Person person){
//        Person person = new Person(first_name, last_name, mobile, birthday, home_id);
        String sql = createInsertStatement(person);
        template.execute(sql);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity getAllPeople(){
        String sql = "SELECT * FROM person";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

//    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
//    public ResponseEntity getPersonById(Integer id){
//        String sql = "SELECT * FROM person WHERE id = " + id;
//        Iterable people = template.queryForObject;
//        return new ResponseEntity(people, HttpStatus.OK);
//    }

    private String createInsertStatement(Person person){
        String sql = "INSERT INTO PERSON(first_name, last_name, mobile, birthday, home_id) VALUES( '" +
                person.getFirst_name() + "','" + person.getLast_name() + "','" + person.getMobile() + "','" + person.getBirthday() + "','" + person.getHome_id()
                + "')";
        return sql;
    }
}
