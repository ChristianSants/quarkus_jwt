package dev.ifrs;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/sum")
public class Bff {

    @Inject
    @RestClient
    BackendClient client;

    @GET
    @Path("/{a}/{b}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"Admin"})
    public int sum(@PathParam("a") int a, @PathParam("b") int b) {
        return client.getSum(a, b);
    }
}