package com.pcp.random.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.pcp.random.sample")
@EntityScan(basePackages = "com.pcp.random.sample")
@SpringBootApplication
public class MbaSearchApplication {

    public static void main(String... args) {
        SpringApplication.run(MbaSearchApplication.class, args);
    }
}