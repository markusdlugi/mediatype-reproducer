package com.example.haljson.working;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.haljson.model.Entity;

@Path("/working")
@Produces({MediaType.APPLICATION_JSON, "application/hal"})
public class SomeResource {

    @GET
    @Path("/")
    public Entity hello() {
        return new Entity("hi");
    }
}
