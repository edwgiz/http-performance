package com.github.edwgiz.sample.microservice.http.performance.jersey;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.status;

@Path("")
@Singleton
public class SampleEndpoint {

    @Path("sample")
    @PUT
    @Consumes(TEXT_PLAIN)
    @Produces(TEXT_PLAIN)
    public Response sample(String value) {
        return status(CREATED).entity("Hello " + value + "!").build();
    }
}
