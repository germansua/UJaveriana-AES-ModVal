package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.List;

@Path("catalogue")
public class CatalogueResource {

    private WebTarget target;

    @PostConstruct
    private void init() {
        target = ClientBuilder
                .newClient()
                .target("http://currency-exchange:8090/CurrencyExchange")
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
                .request().get();
        String rawValue = Json.createParser(new StringReader(response.getEntity().toString())).getValue().toString();
        return new Catalogue(catalogue.getId(), catalogue.getBrand(), catalogue.getProduct(), Double.valueOf(rawValue));
    }
}
