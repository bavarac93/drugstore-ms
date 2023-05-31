package com.pharma.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DrugstoreManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugstoreManagementSystemApplication.class, args);
    }

}
