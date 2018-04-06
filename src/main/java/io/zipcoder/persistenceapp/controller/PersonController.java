package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable int id){
        return service.getPersonById(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPersons () {
        return service.getAllPerson();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable int id) {
        service.deletePerson(id);
    }

}
