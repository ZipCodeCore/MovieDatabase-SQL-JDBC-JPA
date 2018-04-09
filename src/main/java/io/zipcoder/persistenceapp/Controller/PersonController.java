package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return personService.findById(id);
    }
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return personService.getAllPeople();
    }
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        return personService.updatePerson(person);
    }
    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        return personService.removePerson(id);
    }

//    @RequestMapping(value = "/people/reverselookup/{mobile}", method = RequestMethod.GET)
//    public ResponseEntity<Iterable<Person>> reverseLookup(@PathVariable String mobile) {
//        return personService.reverseLookup(mobile);
//    }
//
//    @RequestMapping(value = "/people/surname/{lastName}", method = RequestMethod.GET)
//    public ResponseEntity<Iterable<Person>> surnameLookup(@PathVariable String lastName) {
//        return personService.findByLastName(lastName);
//    }

//    @RequestMapping(value = "/people/firstname/stats", method = RequestMethod.GET)
//    public ResponseEntity<Map<String, Integer>> firstNameWithStats() {
//        return personService.getFirstNameStats();
//    }
}
