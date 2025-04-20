package io.zipcoder.persistenceapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public Person create(Person person) {
        return repo.save(person);
    }

    public Person read(Long id) {
        return repo.findOne(id);
    }

    public List<Person> findAllByNames(String firstName) {
        List<Person> personList = new ArrayList<>();
        readAll().forEach(person -> {
            if (person.getFirstName().equals(firstName))
                personList.add(person);
        });
        return personList;
    }

    public List<Person> findAllByLastName(String lastName) {
        List<Person> personList = new ArrayList<>();
        readAll().forEach(person -> {
            if (person.getLastName().equals(lastName))
                personList.add(person);
        });
        return personList;
    }

    public List<Person> findByMobile(String mobile) {
        List<Person> result = new ArrayList<>();
        readAll().forEach(person -> {
            if(person.getMobile().equals(mobile))
                result.add(person);
        });
        return result;
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = repo.findAll();
        List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        return personList;
    }

    public Person update(Long id, Person newPersonData) {
        Person personInDb = read(id);
        personInDb.setFirstName(newPersonData.getFirstName());
        personInDb.setLastName(newPersonData.getLastName());
//        personInDb.setBirthDate(newPersonData.getBirthDate());
        personInDb.setMobile(newPersonData.getMobile());
        personInDb.setHome_id(newPersonData.getHome_id());
        personInDb = repo.save(personInDb);
        return personInDb;
    }

    public Person delete(Long id) {
        Person personInDb = read(id);
        repo.delete(personInDb);
        return personInDb;
    }

    public Person delete(Person person) {
        return delete(person.getId());
    }

    public List<Person> delete(List<Person> listToDelete) {
        listToDelete.forEach(repo::delete);
        return listToDelete;
    }
}
