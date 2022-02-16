package com.tuana9a.learnjavaspringboot;

import com.tuana9a.learnjavaspringboot.config.AppConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2
@SpringBootApplication
public class LearnJavaSpringBootApplication implements CommandLineRunner {

    @Autowired
    private AppConfig config;

    public static void main(String[] args) {
        SpringApplication.run(LearnJavaSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info(config);
    }
}