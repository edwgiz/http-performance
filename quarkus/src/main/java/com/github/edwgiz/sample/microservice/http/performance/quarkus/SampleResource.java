package com.github.edwgiz.sample.microservice.http.performance.quarkus;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static io.smallrye.mutiny.Uni.createFrom;


@Path("/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class SampleResource {

    @PUT
    @Path("/sample")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> sample(String value) {
        return createFrom().item(value).onItem().apply(v -> "Hello " + value + "!");
    }
}