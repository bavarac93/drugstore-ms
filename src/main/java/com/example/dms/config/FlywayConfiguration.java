package com.example.dms.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

//@Configuration
//public class FlywayConfiguration {
//
//    @Autowired
//    public FlywayConfiguration(DataSource dataSource) {
//        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
//    }
//}

//  @Configuration
//  public class EmptyMigrationStrategyConfig {
//
//    @Bean
//    public FlywayMigrationStrategy flywayMigrationStrategy() {
//        return flyway -> {
//            // do nothing
//        };
//    }
