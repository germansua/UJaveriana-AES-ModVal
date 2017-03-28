package co.edu.javeriana.aes.modval.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("message")
public class MessageResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public String getMessage() {
        return "Hello from Wildfly Swarm at: " + System.currentTimeMillis();
    }
}
