package com.jaeeunyoo.datasource.mysql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Value("${databaseUrl}")
    private String databaseUrl;

    @Value("${databaseUserName}")
    private String databaseUserName;

    @Value("${databasePassword}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
            .url(databaseUrl)
            .username(databaseUserName)
            .password(databasePassword)
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .build();
    }
}
