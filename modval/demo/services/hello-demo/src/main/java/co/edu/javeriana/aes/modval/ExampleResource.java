package co.edu.javeriana.aes.modval;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/hello")
public class ExampleResource {

    @Inject
    @RestClient
    DemoTime demoTime;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello: " + demoTime.getTime();
    }
}