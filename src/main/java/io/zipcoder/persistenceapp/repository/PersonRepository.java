package io.zipcoder.persistenceapp.repository;

import io.zipcoder.persistenceapp.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {


}
