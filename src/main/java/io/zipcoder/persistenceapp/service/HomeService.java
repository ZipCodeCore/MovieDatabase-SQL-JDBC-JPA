package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Home;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
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
}
