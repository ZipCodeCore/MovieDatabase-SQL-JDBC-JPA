package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Domain.Person;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements org.springframework.jdbc.core.RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("ID"));
        person.setFirstName(resultSet.getString("FIRST_NAME"));
        person.setLastName(resultSet.getString("LAST_NAME"));
        person.setMobileNumber(resultSet.getString("MOBILE"));
        person.setBirthDate(resultSet.getDate("BIRTHDAY"));
        person.setHomeId(resultSet.getInt("HOME_ID"));

        return person;
    }
}
