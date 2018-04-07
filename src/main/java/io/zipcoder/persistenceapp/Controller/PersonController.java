package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Domain.Person;
import io.zipcoder.persistenceapp.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@PathVariable int id){
        return personService.getSinglePersonById(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Person> getAllPerson(){
        return null;
    }

}
