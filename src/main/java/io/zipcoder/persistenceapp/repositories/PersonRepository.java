package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {
}
