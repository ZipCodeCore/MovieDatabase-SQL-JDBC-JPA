package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {


    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
//        Person person =
//    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> lookUpId(@PathVariable int id) {
        Person person = personService.findById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }





}
