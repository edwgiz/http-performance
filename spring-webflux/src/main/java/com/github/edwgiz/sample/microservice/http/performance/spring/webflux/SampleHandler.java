package com.github.edwgiz.sample.microservice.http.performance.spring.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SampleHandler implements HandlerFunction<ServerResponse> {

    @Override
    public Mono<ServerResponse> handle(ServerRequest req) {
        final Flux<String> reqBody = req.bodyToFlux(String.class);
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                Mono.just("Hello ").cache().concatWith(reqBody).concatWith(Mono.just("!").cache()),
                String.class);
    }
}
