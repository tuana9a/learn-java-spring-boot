package com.tuana9a;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

@AllArgsConstructor
public class LearnJavaSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LearnJavaSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}