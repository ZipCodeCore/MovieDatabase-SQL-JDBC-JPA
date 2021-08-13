package io.zipcoder.persistenceapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HomeRepo repo;
//    @Autowired
//    private Person person;

    public Home create(Home home) {
        return repo.save(home);
    }

    public Home read(Long homeId) {
        return repo.findOne(homeId);
    }

    public List<Home> readAllHomes() {
        Iterable<Home> homeIterable = repo.findAll();
        List<Home> homeList = new ArrayList<>();
        homeIterable.forEach(homeList::add);
        return homeList;
    }

    public List<Home> readByAddress(String address) {
        List<Home> homeList = new ArrayList<>();
        readAllHomes().forEach(h -> {
            if(h.getAddress().equals(address))
                homeList.add(h);
        });
        return homeList;
    }

    public List<Home> readByHomeNumber(String homeNumber) {
        List<Home> homeList = new ArrayList<>();
        readAllHomes().forEach(h -> {
            if(h.getAddress().equals(homeNumber))
                homeList.add(h);
        });
        return homeList;
    }

    // not too confident about this one
//    public List<Home> findHomeByPerson(Long id) {
//        List<Home> homeList = new ArrayList<>();
//        readAllHomes().forEach(h -> {
//            if (person.getHome_id().equals(id))
//                homeList.add(h);
//        });
//        return homeList;
//    }

    public Home update(Long homeId, Home theNewHome) {
        Home homeInDb = read(homeId);
        homeInDb.setAddress(theNewHome.getAddress());
        homeInDb.setHomeNumber(theNewHome.getHomeNumber());
        homeInDb = repo.save(homeInDb);
        return homeInDb;
    }

    public Home delete(Long id) {
        Home homeInDb = read(id);
        repo.delete(homeInDb);
        return homeInDb;
    }

    public Home delete(Home home) {
        return delete(home.getHome_id());
    }

    public List<Home> delete(List<Home> listToDelete) {
        listToDelete.forEach(repo::delete);
        return listToDelete;
    }
}
