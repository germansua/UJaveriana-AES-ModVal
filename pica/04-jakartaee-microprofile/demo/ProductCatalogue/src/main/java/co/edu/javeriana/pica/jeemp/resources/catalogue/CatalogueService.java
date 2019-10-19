package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.List;

@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CatalogueService {

    @PersistenceContext(name = "catalogue-pu")
    private EntityManager entityManager;

    private WebTarget target;

    @PostConstruct
    private void init() {
        target = ClientBuilder
                .newClient()
                .target("http://currency-exchange:8080/currency-exchange")
                .path("/api/resources/exchange");
    }

    public List<Catalogue> fetchAll() {
        return entityManager
                .createNamedQuery("Catalogue.findAll", Catalogue.class)
                .getResultList();
    }

    public Catalogue fetchById(long id) {
        return entityManager
                .createNamedQuery("Catalogue.findById", Catalogue.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst()
                .orElse(new Catalogue());
    }

    public Catalogue fetchByIdPriceByCurrency(long id, String currency) {
        Catalogue catalogue = fetchById(id);
        double price;

        if (currency != null && !currency.isEmpty()) {
            Response response = target
                    .queryParam("currency", currency)
                    .queryParam("value", catalogue.getPrice())
                    .request()
                    .get();

            String rawResponse = response.readEntity(JsonObject.class).toString();

            try (JsonReader reader = Json.createReader(new StringReader(rawResponse))) {
                JsonObject jsonResponse = reader.readObject();
                price = jsonResponse.getJsonNumber("newValue").doubleValue();
            }
        } else {
            price = catalogue.getPrice();
        }

        return new Catalogue(catalogue.getId(), catalogue.getBrand(), catalogue.getProduct(), price);
    }
}
