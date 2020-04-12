package com.github.edwgiz.sample.microservice.http.performance.reactor.netty;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import static io.netty.handler.codec.http.HttpResponseStatus.CREATED;

public class Application {

    public static void main(String[] args) {
        final DisposableServer server =
                HttpServer.create().port(8080)
                        .route(routes -> {
                            routes.put("/sample", (req, res) -> {
                                final Flux<byte[]> reqBody = req.receive().retain().asByteArray();
                                return res.status(CREATED).header("content-type", "text-plain")
                                        .sendByteArray(Mono.just("Hello ".getBytes()).cache()
                                                .concatWith(reqBody).concatWith(Mono.just("!".getBytes()).cache()));
                            });
                        })
                        .bindNow();

        server.onDispose().block();
    }

}
