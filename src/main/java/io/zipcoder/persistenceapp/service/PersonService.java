package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.cache.PersonSurnameSearchCache;
import io.zipcoder.persistenceapp.domain.Person;
import io.zipcoder.persistenceapp.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PersonService {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    PersonSurnameSearchCache surnameCache;


    public Person getPersonById(int personId) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM PERSON WHERE ID = ?";
        return (Person) jdbc.queryForObject(sql, new Object[]{personId}, new PersonRowMapper());

    }

    public List<Person> getAllPerson() throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM PERSON";
        List<Person> people = new ArrayList<>();
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        buildPersonList(people, rows);
        return people;
    }

    public void deletePerson(int personId) throws EmptyResultDataAccessException {
        String sql = "DELETE FROM PERSON WHERE ID = " + personId;
        jdbc.execute(sql);
    }

    public Person getPersonByMobile(String mobile) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM PERSON WHERE MOBILE = ?";
        return (Person) jdbc.queryForObject(sql, new Object[]{mobile}, new PersonRowMapper());
    }

    public List<Person> getAllPersonWithSurname(String lastName) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM PERSON WHERE LAST_NAME = ?";
        List<Person> people = new ArrayList<>();
        List<Map<String, Object>> rows = jdbc.queryForList(sql, new Object[]{lastName});
        buildPersonList(people, rows);
        surnameCache.setCache(people);
        return people;
    }

    public List<Person> getSurnameCache() {
        return surnameCache.getCache();
    }

    public Map<String,Number> getFirstNameStats () {
        Map<String,Number> outputMap = new HashMap<>();
        String sql = "SELECT first_name, COUNT(first_name) FROM person GROUP BY first_name";
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        for(Map row : rows){
            String name = (String) row.get("FIRST_NAME");
            Number frequency = (Number) row.get("COUNT(FIRST_NAME)");
            outputMap.put(name, frequency);
        }
        return outputMap;
    }

    public void addPerson(Person person) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO person ( LAST_NAME, FIRST_NAME, MOBILE, BIRTHDAY, HOME_ID ) VALUES ('" + person.getLastName() +
                "','" + person.getFirstName() + "','" + person.getMobile() + "','" + format.format(person.getBirthday()) + "','" + person.getHomeId() + "')";
        jdbc.execute(sql);
    }

    public void updatePerson(Person person, int id) throws EmptyResultDataAccessException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "UPDATE person SET FIRST_NAME = '" + person.getFirstName() +"', LAST_NAME = '" + person.getLastName() +
                "', MOBILE = '" + person.getMobile() + "', BIRTHDAY = '" + format.format(person.getBirthday()) + "', HOME_ID = '" +
                person.getHomeId() + "' WHERE ID = " + id;
        jdbc.execute(sql);
    }

    private void buildPersonList(List<Person> listToBuild, List<Map<String, Object>> results) {
        for (Map row : results) {
            Person person = new Person();
            person.setId((int) row.get("ID"));
            person.setFirstName((String) row.get("FIRST_NAME"));
            person.setLastName((String) row.get("LAST_NAME"));
            person.setMobile((String) row.get("MOBILE"));
            person.setBirthday((Date) row.get("BIRTHDAY"));
            person.setHomeId((short) row.get("HOME_ID"));
            listToBuild.add(person);
        }

    }


}
