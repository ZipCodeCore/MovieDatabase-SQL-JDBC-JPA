package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Home;
import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.rowmapper.HomeRowMapper;
import io.zipcoder.persistenceapp.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    JdbcTemplate jdbc;

    public Home getHomeById(int homeId) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM HOME WHERE ID = ?";
        return (Home) jdbc.queryForObject(sql, new Object[]{homeId}, new HomeRowMapper());
    }

}
