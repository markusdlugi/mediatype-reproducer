package com.example.haljson.api;

import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Produces;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({ "application/hal" })
@ConstrainedTo(RuntimeType.SERVER)
public class HalProvider extends AbstractHalJsonProvider {
}
