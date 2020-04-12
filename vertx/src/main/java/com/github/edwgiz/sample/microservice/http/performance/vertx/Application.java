package com.github.edwgiz.sample.microservice.http.performance.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.impl.BufferImpl;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import static io.vertx.core.http.HttpHeaders.CONTENT_TYPE;

public class Application {

    public static void main(String[] args) {
//        System.setProperty("vertx.nettyIORatio", "1");
        final Vertx vertx = Vertx.vertx();

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(createRouter(vertx));
        server.listen(8080);
    }

    private static Router createRouter(Vertx vertx) {
        Router router = Router.router(vertx);

        router.put("/sample").consumes("text/plain").produces("text/plain").handler(rc -> {
            rc.request().bodyHandler(requestBody -> {
                final BufferImpl out = new BufferImpl();
                out.appendString("Hello ").appendBuffer(requestBody).appendString("!");
                rc.response()
                        .setStatusCode(201)
                        .putHeader(CONTENT_TYPE, "text/plain")
                        .end(out);
            });
        });
        return router;
    }

}
