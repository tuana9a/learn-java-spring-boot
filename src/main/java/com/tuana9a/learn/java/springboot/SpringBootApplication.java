package com.tuana9a.learn.java.springboot;

import com.tuana9a.learn.java.springboot.config.AppConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


@Log4j2
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {

    @Autowired
    private AppConfig config;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info(config);
    }
}