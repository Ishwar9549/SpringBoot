package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJwtApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringJwtApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtApplication.class, args);
        logger.info("Spring JWT application started successfully.");
    }
}
//100%