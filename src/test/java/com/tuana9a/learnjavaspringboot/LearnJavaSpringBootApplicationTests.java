package com.tuana9a.learnjavaspringboot;

import com.tuana9a.learnjavaspringboot.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnJavaSpringBootApplicationTests {

    @Autowired
    private AppConfig config;

    @Test
    public void generateUsers() {
        // TODO
    }

    @Test
    public void generateOrders() {
        // TODO
    }

    @Test
    public void generateProducts() {
        // TODO
    }

    @Test
    public void printConfig() {
        System.out.println(config);
    }

}
