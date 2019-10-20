package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.TimeUnit;

@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CatalogueService {

    @PersistenceContext(name = "catalogue-pu")
    private EntityManager entityManager;

    private Client client;
    private WebTarget target;

    @PostConstruct
    private void init() {
        client = ClientBuilder
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        target = client.target("http://currency-exchange:8080").path("/api/resources/exchange");
    }

    public List<Catalogue> fetchAll() {
        return entityManager
                .createNamedQuery("Catalogue.findAll", Catalogue.class)
                .getResultList();
    }

    private Catalogue fetchById(long id) {
        return entityManager
                .createNamedQuery("Catalogue.findById", Catalogue.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst()
                .orElse(new Catalogue());
    }

    public Catalogue fetchByIdPriceByCurrency(long id, String currency) {
        Catalogue catalogue = fetchById(id);
        double price = catalogue.getPrice();

        if (currency != null && !currency.isEmpty()) {
            Response response = target
                    .queryParam("currency", currency)
                    .queryParam("value", catalogue.getPrice())
                    .request()
                    .get();

            JsonObject rawJsonResponse = response.readEntity(JsonObject.class);
            price = rawJsonResponse.getJsonNumber("newValue").doubleValue();
        }

        return new Catalogue(catalogue.getId(), catalogue.getBrand(), catalogue.getProduct(), price);
    }

    @PreDestroy
    private void tearDown() {
        client.close();
    }
}
