package com.example.haljson.api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.haljson.model.Entity;

@Path("/")
@Produces({APPLICATION_JSON, "application/hal", "application/hal+json"})
public class TestResource {

    @GET
    @Path("/")
    public Entity hello() {
        return new Entity("hi");
    }
}
