package io.zipcoder.persistenceapp.rowmapper;


import io.zipcoder.persistenceapp.domain.Person;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("ID"));
        person.setFirstName(rs.getString("FIRST_NAME"));
        person.setLastName(rs.getString("LAST_NAME"));
        person.setMobile(rs.getString("MOBILE"));
        person.setBirthday(rs.getDate("BIRTHDAY"));
        person.setHomeId(rs.getInt("HOME_ID"));

        return person;
    }
}
