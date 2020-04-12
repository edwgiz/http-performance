package com.github.edwgiz.sample.microservice.http.performance.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

import static io.micronaut.http.HttpResponse.created;


@Controller("/")
@Validated
public class SampleController {

    @Put(uri = "/sample", processes = MediaType.TEXT_PLAIN)
    public HttpResponse<String> sample(@Body String value) {
        return created("Hello " + value + "!");
    }

}
