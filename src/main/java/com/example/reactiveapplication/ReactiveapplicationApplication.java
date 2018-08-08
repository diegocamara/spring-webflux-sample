package com.example.reactiveapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class ReactiveapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveapplicationApplication.class, args);
    }
}
