package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    ResponseEntity<Person> findById(Long id);

    ResponseEntity<Iterable<Person>> getAllPeople();

    ResponseEntity<?> addPerson(Person person);

    ResponseEntity<?> updatePerson(Person person);

    ResponseEntity<?> removePerson(Long personId);

    ResponseEntity<Iterable<Person>> findByLastName(String lastname);

    ResponseEntity<Iterable<Person>> reverseLookup(String mobile);

    ResponseEntity<Iterable<Person>> findByBirthday(String birthday);

//    ResponseEntity<Map<String, List<Person>>> getSurname(String surname);
//
//    ResponseEntity<Map<String, Integer>> getFirstNameWithStats();
}
