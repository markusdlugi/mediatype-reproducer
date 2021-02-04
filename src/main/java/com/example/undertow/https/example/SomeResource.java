package com.example.undertow.https.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class SomeResource {

    @GET
    @Path("/")
    public String hello() {
        return "hello";
    }
}
