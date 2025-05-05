package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "people/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePerson(@PathVariable Integer id, @RequestBody Person person){
        String sql = "UPDATE person SET first_name = '" + person.getFirst_name() + "', last_name = '" + person.getLast_name() + "', mobile = '"
                + person.getMobile() + "', birthday = '" + person.getBirthday() + "', home_id = '" + person.getHome_id() + "' WHERE id = " + id;
        template.execute(sql);
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity getAllPeople(){
        String sql = "SELECT * FROM person";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity getPersonById(@PathVariable Integer id){
        String sql = "SELECT * FROM person WHERE id = " + id;
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePersonById(@PathVariable Integer id){
        String sql = "DELETE FROM person WHERE id = " + id;
        template.execute(sql);
        return new ResponseEntity(HttpStatus.OK);
    }

    //need to come back to this one
    @RequestMapping(value = "/people", method = RequestMethod.DELETE)
    public ResponseEntity deleteGroup(@RequestBody Integer[] ids){
        for (Integer id:ids) {
            String sql = "DELETE FROM person WHERE id = " + id;
            template.execute(sql);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/people/first_name/{first_name}", method = RequestMethod.GET)
    public ResponseEntity findGroupByFirstName(@PathVariable String first_name){
        String sql = "SELECT * FROM person WHERE first_name = '" + first_name + "'";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/last_name/{last_name}", method = RequestMethod.GET)
    public ResponseEntity findGroupByLastName(@PathVariable String last_name){
        String sql = "SELECT * FROM person WHERE last_name = '" + last_name + "'";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/birthday/{birthday}", method = RequestMethod.GET)
    public ResponseEntity findGroupByBirthday(@PathVariable String birthday){
        String sql = "SELECT * FROM person WHERE birthday = '" + birthday + "'";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/last_name", method = RequestMethod.GET)
    public ResponseEntity lastNameOccurences(){
        String sql = "SELECT last_name, COUNT(last_name) FROM person GROUP BY last_name";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/first_name", method = RequestMethod.GET)
    public ResponseEntity firstNameOccurences(){
        String sql = "SELECT first_name, COUNT(first_name) FROM person GROUP BY first_name";
        Iterable people = template.queryForList(sql);
        return new ResponseEntity(people, HttpStatus.OK);
    }

    private String createInsertStatement(Person person){
        String sql = "INSERT INTO PERSON(first_name, last_name, mobile, birthday, home_id) VALUES( '" +
                person.getFirst_name() + "','" + person.getLast_name() + "','" + person.getMobile() + "','" + person.getBirthday() + "','" + person.getHome_id()
                + "')";
        return sql;
    }
}
