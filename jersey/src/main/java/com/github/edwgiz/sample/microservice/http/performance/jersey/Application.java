package com.github.edwgiz.sample.microservice.http.performance.jersey;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Application {

    public static void main(String[] args) throws IOException {
        final org.glassfish.jersey.server.ResourceConfig application = new ResourceConfig();
        application.register(SampleEndpoint.class);
        GrizzlyHttpContainer container = new GrizzlyHttpContainerProvider()
                .createContainer(GrizzlyHttpContainer.class, application);
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(
                URI.create("http://0.0.0.0:8080"),
                container,
                false,
                null,
                false);
        httpServer.getServerConfiguration().setName("grizzly");
        httpServer.start();
    }

}
