package io.zipcoder.persistenceapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    Home findById(Long Id);
    Home findByHomeNumber(String homeNumber);
    Home findByAddress(String address);



}
