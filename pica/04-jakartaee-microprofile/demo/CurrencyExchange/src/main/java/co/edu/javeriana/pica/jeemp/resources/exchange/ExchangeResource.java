package co.edu.javeriana.pica.jeemp.resources.exchange;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

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
    @Timed(name = "getExchangeRateTime", absolute = true, description = "Time taken to process a currency exchange")
    @Counted(name = "getExchangeRateCount", absolute = true, description = "Number of invocations of a currency exchange")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getExchangeRate(@QueryParam("currency") String currency, @QueryParam("value") double value) {
        currency = currency != null ? currency : Currencies.USD.toString();
        return Json.createObjectBuilder()
                .add("to", currency)
                .add("newValue", exchangeService.exchangeUSDTo(currency, value))
                .build();
    }
}
