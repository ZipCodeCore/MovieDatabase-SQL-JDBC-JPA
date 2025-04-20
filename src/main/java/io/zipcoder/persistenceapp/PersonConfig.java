package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PersonConfig {

    @Autowired
    private PersonService service;

    @PostConstruct
    public void setup() {
        service.create(new Person(5L, "Josh", "Wilkins", "12435124", 12L));
        service.create(new Person(6L, "Raf", "Wilkins", "12435124", 12L));
        service.create(new Person(7L, "Vac", "Wilkins", "12435124", 12L));
        service.create(new Person(8L, "Ewda", "Wilkins", "12435124", 12L));
        service.create(new Person(9L, "Palsd", "Wilkins", "12435124", 12L));
    }
}
