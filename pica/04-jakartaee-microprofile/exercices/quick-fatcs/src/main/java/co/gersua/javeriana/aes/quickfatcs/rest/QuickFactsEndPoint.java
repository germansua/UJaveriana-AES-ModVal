package co.gersua.javeriana.aes.quickfatcs.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Path("quick-facts")
public class QuickFactsEndPoint {

    @Inject
    // export WEATHER_URL='http://localhost:9090/api/boundedcontext/v1.0/weather'
    @ConfigProperty(name = "weather.url", defaultValue = "http://localhost:9090/api/boundedcontext/v1.0/weather")
    private String weatherUrl;
    private Client weatherClient;
    private WebTarget target;

    @PostConstruct
    private void init() {
        weatherClient = ClientBuilder.newClient();
        target = weatherClient.target(weatherUrl);
    }

    @GET
    @Retry(maxRetries = 12, delay = 500, jitter = 100)
    @Fallback(fallbackMethod = "getQuickFactsFallback")
    public QuickFactsModel getQuickFacts(@HeaderParam("pica.quick-facts.location") String loc) {

        JsonObject response = target.queryParam("location", loc)
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(JsonObject.class);

        double temperature = response.getJsonNumber("temperature").doubleValue();

        return new QuickFactsModel(
                loc,
                "Bogotá officially Bogotá, Distrito Capital, abbreviated Bogotá, D.C., and formerly known as Santafé/Santa Fe de Bogotá between 1991 and 2000",
                temperature);
    }

    public QuickFactsModel getQuickFactsFallback(String loc) {
        return new QuickFactsModel(
                loc,
                "Bogotá officially Bogotá, Distrito Capital, abbreviated Bogotá, D.C., and formerly known as Santafé/Santa Fe de Bogotá between 1991 and 2000",
                0.0);
    }

    @PreDestroy
    private void finish() {
        weatherClient.close();
    }
}
