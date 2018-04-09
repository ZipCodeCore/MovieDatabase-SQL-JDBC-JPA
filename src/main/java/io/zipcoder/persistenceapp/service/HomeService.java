package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Home;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@RequestMapping
public class HomeService {
    private JdbcTemplate template;

    public HomeService(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @RequestMapping(value = "/homes", method = RequestMethod.GET)
    public ResponseEntity getAllHomes(){
        String sql = "SELECT * FROM home";
        Iterable homes = template.queryForList(sql);
        return new ResponseEntity(homes, HttpStatus.OK);
    }

    @RequestMapping(value = "/homes", method = RequestMethod.POST)
    public ResponseEntity createHome(@RequestBody Home home){
        String sql = "INSERT INTO home (address, homenumber) VALUES('" + home.getAddress() +"','" + home.getHomenumber() + "')";
        template.execute(sql);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateHome(@PathVariable Integer id, @RequestBody Home home){
        String sql = "UPDATE home SET address = '" + home.getAddress() + "', homenumber = '" + home.getHomenumber() + "' WHERE id = " + id;
        template.execute(sql);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteHome(@PathVariable Integer id){
        String sql = "DELETE FROM home WHERE id = " + id;
        template.execute(sql);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.GET)
    public ResponseEntity findHomeById(@PathVariable Integer id){
        String sql = "SELECT * FROM home WHERE id = " + id;
        Iterable home = template.queryForList(sql);
        return new ResponseEntity(home, HttpStatus.OK);
    }
}
