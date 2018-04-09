package io.zipcoder.persistenceapp.humans.repository;

import io.zipcoder.persistenceapp.core.repository.BaseRepository;
import io.zipcoder.persistenceapp.humans.model.Home;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends BaseRepository<Home, Integer> {



}
