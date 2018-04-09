package io.zipcoder.persistenceapp.service.jpa;

import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.service.HomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jpaHomeServiceImpl implements HomeService {

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public void deletePerson(int id) {

    }

    @Override
    public void deletePeople(List<Person> cars) {

    }

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public Person findById(int id) {
        return null;
    }
}
