package io.zipcoder.persistenceapp.cache;

import io.zipcoder.persistenceapp.domain.Person;
import org.hibernate.annotations.Cache;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


public class PersonSurnameSearchCacheImp implements PersonSurnameSearchCache {
    private List<Person> cache = new ArrayList<>();

    public List<Person> getCache() {
        return cache;
    }

    public void setCache(List<Person> cache) {
        this.cache = cache;
    }
}
