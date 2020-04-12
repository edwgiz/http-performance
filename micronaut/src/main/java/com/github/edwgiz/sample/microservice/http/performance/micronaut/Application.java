package com.github.edwgiz.sample.microservice.http.performance.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut Sample Microservice",
                version = "1.0.0",
                description = "Micronaut Sample Microservice",
                termsOfService = "Demo",
                contact = @Contact(email = "edwgiz@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}