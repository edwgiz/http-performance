package com.github.edwgiz.sample.microservice.http.performance.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SampleResourceTest {

    @Test
    public void testSample() throws InterruptedException {
        given()
          .when().body("world").put("/sample")
          .then()
             .statusCode(201)
             .body(is("Hello world!"));
    }

}