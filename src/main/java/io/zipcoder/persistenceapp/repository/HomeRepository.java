package io.zipcoder.persistenceapp.repository;

import io.zipcoder.persistenceapp.domain.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {

}
