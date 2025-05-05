package io.zipcoder.persistenceapp.repository;

import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
