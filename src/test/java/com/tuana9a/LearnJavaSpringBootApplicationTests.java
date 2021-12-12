package com.tuana9a;

import com.tuana9a.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnJavaSpringBootApplicationTests {

    @Autowired
    private AppConfig config;

    @Test
    public void printConfig() {
        System.out.println(config);
    }

}
