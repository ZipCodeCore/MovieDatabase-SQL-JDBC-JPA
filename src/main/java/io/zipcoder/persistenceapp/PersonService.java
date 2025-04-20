package io.zipcoder.persistenceapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }


    public Person addPersonToHome(Long homeId, Long personId) {
        Person p = this.personRepository.getOne(personId);
        p.setHomeId(homeId);
        return this.personRepository.save(p);
    }

    public Person insertPerson(Person person) {
        return this.personRepository.save(person);
    }

    public void deletePerson(Long id) {
        this.personRepository.delete(id);
    }

    public void deletePeople(List<Person> people) {
        this.personRepository.delete(people);
    }

    public List<Person> findAllPeople() {
        return this.personRepository.findAll();
    }

    public Person findPerson(Long id) {
        return this.personRepository.findOne(id);
    }

    public Person updatePerson(Long id, Person person) {
        Person toUpdate = this.personRepository.findOne(id);
        toUpdate.setFirstName(person.getFirstName());
        toUpdate.setLastName(person.getLastName());
        toUpdate.setMobile(person.getMobile());
        toUpdate.setHomeId(person.getHomeId());
        return this.personRepository.save(toUpdate);
    }

    public List<Person> findPersonByFirstName(String firstName) {
        return this.personRepository.findAllByFirstName(firstName);
    }

    public List<Person> findPersonByLastName(String lastName) {
        return this.personRepository.findAllByLastName(lastName);
    }

    public List<Person> findPersonByMobile(String mobile) {
        return this.personRepository.findAllByMobile(mobile);
    }

    public Map<String, List<Person>> getMapSortByLastName() {
        List<Person> people = this.personRepository.findAll();
        HashMap<String, List<Person>> map = new HashMap<>();
        for (Person p : people) {
            if (map.containsKey(p.getLastName())) {
                map.get(p.getLastName()).add(p);
            } else {
                List<Person> value = new ArrayList<Person>();
                value.add(p);
                map.put(p.getLastName(), value);
            }
        }
        return map;
    }

    public Map<String, Integer> getFirstNamesOccur() {
        List<Person> people = this.personRepository.findAll();
        HashMap<String, Integer> map = new HashMap<>();
        for (Person p : people) {
            if (map.containsKey(p.getFirstName())) {
                map.put(p.getFirstName(), map.get(p.getFirstName()) + 1);
            } else {
                map.put(p.getFirstName(), 1);
            }
        }
        return map;
    }

    public Long findHomeByPersonId(Long personId) {
        Person p = this.personRepository.getOne(personId);
        return p.getHomeId();
    }

    public List<Person> getAllPeopleInAHome(Long homeId) {
        return this.personRepository.findAllByHomeId(homeId);
    }
}
