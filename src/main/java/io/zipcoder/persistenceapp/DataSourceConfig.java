package io.zipcoder.persistenceapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class DataSourceConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setName("testdb");
        EmbeddedDatabase build = builder
                .setName("testdb;MODE=MySQL;DB_CLOSE_ON_EXIT=false")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema-h2.sql")
                .addScript("classpath:data-h2.sql")
                .build();
        return build;

    }
}
