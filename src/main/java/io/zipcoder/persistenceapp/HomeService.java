package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;


    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<Home> findAllHomes() {
        return this.homeRepository.findAll();
    }

    public Home insertHome(Home home) {
        return this.homeRepository.save(home);
    }

    public void removeHome(Long id) {
        this.homeRepository.delete(id);
    }

    public void removeHomes(List<Home> homes) {
        this.homeRepository.delete(homes);
    }

    public Home updateHome(Home home) {
        Home toUpdate = this.homeRepository.getOne(home.getId());//  findById(home.getId());
        toUpdate.setAddress(home.getAddress());
        toUpdate.setHomeNumber(home.getHomeNumber());
        return this.homeRepository.save(toUpdate);
    }

    public Home findHomeById(Long id) {
        return this.homeRepository.findById(id);
    }

    public Home findHomeByHomeNumber(String homeNumber) {
        return this.homeRepository.findByHomeNumber(homeNumber);
    }

    public Home findHomeByAddress(String address) {
        return this.homeRepository.findByAddress(address);
    }

}

//    public Person create(Person person) {
//        return repository.save(person);
//    }
//
//    public Person findById(Long id) {
//        return repository.findOne(id);
//    }
//
//    public List<Person> readAll() {
//        Iterable<Person> personIterable = repository.findAll();
//        List<Person> result = new ArrayList<>();
//        personIterable.forEach(result::add);
//        return result;
//    }
//
//    public Person update(Long id, Person newPersonData) {
//        Person personInDatabase = findById(id);
//        newPersonData.setId(personInDatabase.getId());
//        return repository.save(newPersonData);
//    }
//
//    public Person delete(Person person) {
//        repository.delete(person);
//        return person;
//    }
//
//    public Person delete(Long id) {
//        return delete(findById(id));
//    }

