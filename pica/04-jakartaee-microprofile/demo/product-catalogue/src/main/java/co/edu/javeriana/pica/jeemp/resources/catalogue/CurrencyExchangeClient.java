package co.edu.javeriana.pica.jeemp.resources.catalogue;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Dependent
@RegisterRestClient
public interface CurrencyExchangeClient {

    @Path("/api/resources/exchange")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    JsonObject getExchangeRate(@QueryParam("currency") String currency, @QueryParam("value") double value);
}
