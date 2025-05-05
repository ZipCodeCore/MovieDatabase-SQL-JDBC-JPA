package io.zipcoder.persistenceapp.config;

import io.zipcoder.persistenceapp.cache.PersonSurnameSearchCache;
import io.zipcoder.persistenceapp.cache.PersonSurnameSearchCacheImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonSurnameSearchCache personSurnameSearchCache(){
        return new PersonSurnameSearchCacheImp();
    }
}
