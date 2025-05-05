package io.zipcoder.persistenceapp.humans.service;

import io.zipcoder.persistenceapp.humans.model.Person;
import io.zipcoder.persistenceapp.humans.repository.PersonRepository;
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
