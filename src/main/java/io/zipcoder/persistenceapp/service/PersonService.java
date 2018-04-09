package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.model.Person;
import io.zipcoder.persistenceapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

}
