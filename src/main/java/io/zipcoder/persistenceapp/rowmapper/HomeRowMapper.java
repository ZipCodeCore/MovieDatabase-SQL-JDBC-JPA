package io.zipcoder.persistenceapp.rowmapper;

import io.zipcoder.persistenceapp.domain.Home;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Home home = new Home();
        home.setId(rs.getInt("ID"));
        home.setAddress(rs.getString("ADDRESS"));
        home.setHomeNumber(rs.getString("HOMENUMBER"));

        return home;
    }
}
