package co.edu.javeriana.pica.jeemp.resources;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("exchange")
public class ExchangeResource {

    @Inject
    private ExchangeService exchangeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getExchangeRate(@QueryParam("currency") String currency, @QueryParam("value") double value) {
        return Json.createObjectBuilder()
                .add("to", currency)
                .add("newValue", exchangeService.exchangeUSDTo(currency, value))
                .build();
    }
}
