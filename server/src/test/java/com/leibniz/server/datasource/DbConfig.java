package com.leibniz.server.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableJpaRepositories(basePackages = "com.leibniz.server.dao.*")
public class DbConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();
        basicDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        basicDataSource.setUrl(env.getProperty("spring.datasource.url"));
        basicDataSource.setUsername(env.getProperty("spring.datasource.username"));
        basicDataSource.setPassword(env.getProperty("spring.datasource.password"));
        return basicDataSource;

    }
}
