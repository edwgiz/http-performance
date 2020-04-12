package com.github.edwgiz.sample.microservice.http.performance.spring.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses =
        com.github.edwgiz.sample.microservice.http.performance.spring.webflux.SampleRouter.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
