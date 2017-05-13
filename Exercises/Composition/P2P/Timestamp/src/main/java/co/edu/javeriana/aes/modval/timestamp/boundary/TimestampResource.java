package co.edu.javeriana.aes.modval.timestamp.boundary;

import co.edu.javeriana.aes.modval.timestamp.control.TimestampService;
import co.edu.javeriana.aes.modval.timestamp.entity.Timestamp;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class represents the resource. It is also consider the boundary or protocol adaptor.
 * In this case an adaptor to a REST like service
 * */
@Path("ts")
public class TimestampResource {

    /* Dependency injection is being used here */
    @Inject
    private TimestampService timestampService;

    /* This supports GET HTTP verb/method, and two representations for the resource: XML and JSON */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Timestamp doGet() {
        return timestampService.getCurrentTimestamp();
    }
}
