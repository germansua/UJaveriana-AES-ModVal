package co.edu.javeriana.pica.jeemp.resources.exchange;

import io.opentracing.Tracer;
import io.vavr.control.Try;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;

@Path("exchange")
public class ExchangeResource {

    @Inject
    private ExchangeService exchangeService;

    @Inject
    private Tracer tracer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Traced(operationName = "ExchangeResource.getExchangeRate")
    @Timed(name = "ExchangeResource_getExchangeRateTime", absolute = true, description = "Time taken to process a currency exchange")
    @Counted(name = "ExchangeResource_getExchangeRateCount", absolute = true, description = "Number of invocations of a currency exchange")
    @Metered(name = "ExchangeResource_getExchangeRateMetered", tags = {"endpoint=rest"}, description = "Throughput of a currency exchange")
    public JsonObject getExchangeRate(@QueryParam("currency") String currency, @QueryParam("value") double value) {
        currency = currency != null ? currency : Currencies.USD.toString();
        String hostName = Try.of(() -> InetAddress.getLocalHost().getHostName()).getOrElse("null");

        return Json.createObjectBuilder()
                .add("host", hostName)
                .add("to", currency)
                .add("newValue", exchangeService.exchangeUSDTo(currency, value))
                .build();
    }
}
