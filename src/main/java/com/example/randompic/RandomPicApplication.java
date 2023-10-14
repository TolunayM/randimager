package com.example.randompic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;

@SpringBootApplication
public class RandomPicApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomPicApplication.class, args);
    }

}
