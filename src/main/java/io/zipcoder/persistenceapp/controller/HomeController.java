package io.zipcoder.persistenceapp.controller;


import io.zipcoder.persistenceapp.domain.Home;
import io.zipcoder.persistenceapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    HomeService service;

    @RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getHomeById(@PathVariable int id){
        try {
            Home home = service.getHomeById(id);
            return new ResponseEntity<>(home, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>("Home Not Found In Database",HttpStatus.NOT_FOUND);
        }
    }

}
