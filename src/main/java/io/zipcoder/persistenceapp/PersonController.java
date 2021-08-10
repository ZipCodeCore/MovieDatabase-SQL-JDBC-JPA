package io.zipcoder.persistenceapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

@RestController
@RequestMapping (value = "/person-controller")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(method = RequestMethod.POST, value = "/people")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/people/{id}")
    public ResponseEntity<Person> update(@RequestBody Long id, Person person) {
            return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@RequestBody Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/people/{id}")
    public ResponseEntity<Person> delete(@RequestBody Long id) {
            return new ResponseEntity<>(service.delete(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people")
    public ResponseEntity<List<Person>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/reverselookup/{mobileNumber}")
    public ResponseEntity<Person> findByMobile(@RequestBody Integer phoneNumber) {
        return null;
    }
}
