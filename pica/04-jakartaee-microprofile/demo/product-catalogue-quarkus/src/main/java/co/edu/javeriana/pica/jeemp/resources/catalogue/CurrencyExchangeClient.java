package co.edu.javeriana.pica.jeemp.resources.catalogue;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Dependent
@RegisterRestClient
public interface CurrencyExchangeClient {

    @Path("/api/resources/exchange")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    JsonObject getExchangeRate(@QueryParam("currency") String currency, @QueryParam("value") double value);
}
