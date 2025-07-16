package com.bms.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowManagementSystemApplication.class, args);
    }

}
