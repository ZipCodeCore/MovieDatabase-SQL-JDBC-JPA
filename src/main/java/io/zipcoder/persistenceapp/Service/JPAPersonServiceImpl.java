package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.domain.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Primary
@Service
public class JPAPersonServiceImpl implements PersonService{

    private PersonRepository personRepository;
    /**
     * To-Do: findAll LastNames, FirstNames, Birthdays,Mobile.
     * Done with: basic methods.
     * @param personRepository
     */
    @Autowired
    public JPAPersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public ResponseEntity<Person> findById(Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Iterable<Person>> getAllPeople() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> addPerson(Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> updatePerson(Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> removePerson(Long id) {
        personRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Iterable<Person>> findByLastName(String lastname) {
        return null;
    }
    @Override
    public ResponseEntity<Iterable<Person>> reverseLookup(String mobile) {
        return null;
    }
    @Override
    public ResponseEntity<Iterable<Person>> findByBirthday(String birthday) {
        return null;
    }
//    @Override
//    public ResponseEntity<Map<String, List<Person>>> getSurname(String surname) {
//        return null;
//    }
//    @Override
//    public ResponseEntity<Map<String, Integer>> getFirstNameWithStats() {
//        return null;
//    }
}
