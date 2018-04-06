package io.zipcoder.persistenceapp;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

}
