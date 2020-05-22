package co.edu.javeriana.aes.modval;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient
@Path("/api/time")
public interface DemoTime {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getTime();
}
