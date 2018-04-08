package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Domain.Person;
import io.zipcoder.persistenceapp.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//where the mapping goes
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSinglePersonById(@PathVariable Long id){
        personService.getSinglePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPersons(){
        personService.getAllPersons();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePersonById(@PathVariable Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/person/{last_name}", method = RequestMethod.GET)
    public ResponseEntity<?> findPersonByLastName(@PathVariable String last_name){
        personService.findPersonByLastName(last_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person){
        personService.getSinglePersonById(id);
        personService.updatePerson(person, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
