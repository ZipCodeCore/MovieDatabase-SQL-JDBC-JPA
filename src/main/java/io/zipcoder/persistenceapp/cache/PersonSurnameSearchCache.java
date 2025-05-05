package io.zipcoder.persistenceapp.cache;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface PersonSurnameSearchCache {

    public List<Person> getCache();
    public void setCache(List<Person> cache);
}
