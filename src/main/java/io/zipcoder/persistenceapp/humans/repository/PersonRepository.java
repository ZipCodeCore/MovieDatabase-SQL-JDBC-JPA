package io.zipcoder.persistenceapp.humans.repository;

import io.zipcoder.persistenceapp.core.repository.BaseRepository;
import io.zipcoder.persistenceapp.humans.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {



}
