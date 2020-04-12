package com.github.edwgiz.sample.microservice.http.performance.grizzly;

import org.glassfish.grizzly.Buffer;
import org.glassfish.grizzly.http.io.OutputBuffer;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import static org.glassfish.grizzly.http.util.HttpStatus.CREATED_201;

public class Application {

    public static void main(String[] args) {
        HttpServer server = HttpServer.createSimpleServer(".", 8080);
        server.getServerConfiguration().addHttpHandler(
                new HttpHandler() {
                    public void service(Request req, Response resp) throws Exception {
                        final Buffer reqBody = req.getPostBody(req.getContentLength());
                        resp.setStatus(CREATED_201);
                        resp.setContentType("text/plain");
                        final OutputBuffer out = resp.getOutputBuffer();
                        out.write("Hello ");
                        out.write(reqBody.toStringContent());
                        out.write("!");
                    }
                },
                "/sample");
        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
