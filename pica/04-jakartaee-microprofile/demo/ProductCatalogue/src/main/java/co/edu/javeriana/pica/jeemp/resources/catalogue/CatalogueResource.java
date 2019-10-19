package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.List;

@Path("catalogue")
public class CatalogueResource {

    private WebTarget target;

    @PostConstruct
    private void init() {
        target = ClientBuilder
                .newClient()
                .target("http://currency-exchange:8080/currency-exchange")
                .path("/api/resources/exchange");
    }

    @Inject
    private CatalogueService catalogueService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogue> getAll() {
        return catalogueService.fetchAll();
    }

    @GET
    @Path("{id}")
    public Catalogue get(@PathParam("id") long id, @QueryParam("currency") String currency) {
        Catalogue catalogue = catalogueService.fetchById(id);
        Response response = target
                .queryParam("currency", currency)
                .queryParam("value", catalogue.getPrice())
                .request()
                .get();

        String rawResponse = response.readEntity(JsonObject.class).toString();

        try (JsonReader reader = Json.createReader(new StringReader(rawResponse))) {
            JsonObject jsonResponse = reader.readObject();
            return new Catalogue(
                    catalogue.getId(),
                    catalogue.getBrand(),
                    catalogue.getProduct(),
                    jsonResponse.getJsonNumber("newValue").doubleValue());
        }
    }
}
