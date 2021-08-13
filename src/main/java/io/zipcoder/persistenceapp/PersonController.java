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

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Person> create(
            @RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/people/u/{id}")
    public ResponseEntity<Person> update(
            @PathVariable Long id,
            @RequestBody Person person) {
            return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/r/{id}")
    public ResponseEntity<Person> getPerson(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/people/d/{id}")
    public ResponseEntity<Person> delete(
            @PathVariable Long id) {
            return new ResponseEntity<>(service.delete(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity<List<Person>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/reverselookup/{mobileNumber}")
    public ResponseEntity<List<Person>> findByMobile(
            @PathVariable String phoneNumber) {
        return new ResponseEntity<>(service.findByMobile(phoneNumber), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/people/surname/{lastName}")
    public ResponseEntity<List<Person>> findByLastName(
            @PathVariable String lastName) {
        return new ResponseEntity<>(service.findAllByLastName(lastName), HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/people/surname/{firstName}")
//    public ResponseEntity<List<Person>> findByFirstName(@PathVariable String firstName) {
//        return new ResponseEntity<>(service.findAllByLastName(firstName), HttpStatus.OK);
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/people/firstname/stats")
//    public ResponseEntity<List<Person>> firstNameFrequency() {
//
//    }
}
