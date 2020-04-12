package com.github.edwgiz.sample.microservice.http.performance.spring.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SampleRouter {

    @Bean
    public RouterFunction<ServerResponse> sampleRoute(SampleHandler handler) {
        return route(PUT("/sample").and(accept(TEXT_PLAIN)), handler);
    }
}
