package co.edu.javeriana.pica.jeemp.resources.catalogue;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Dependent
@Transactional(Transactional.TxType.SUPPORTS)
public class CatalogueService {

    private static Logger LOGGER = Logger.getLogger(CatalogueService.class.getName());

    // @PersistenceContext(name = "catalogue-pu")
    @Inject
    EntityManager entityManager;

    @Inject
    @ConfigProperty(name = "currency.exchange.hostname")
    String currencyExchangeServiceHostname;

    @Inject
    @ConfigProperty(name = "currency.exchange.port", defaultValue = "8080")
    int currencyExchangeServicePort;

    @Inject
    @ConfigProperty(name = "currency.resource.path")
    Optional<String> currencyExchangePath;

    @Inject
    @RestClient
    CurrencyExchangeClient currencyExchangeClient;

    private Client client;
    private WebTarget target;

    @PostConstruct
    void init() {
        client = ClientBuilder
                .newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();

        target = client
                .target(String.format("http://%s:%d", currencyExchangeServiceHostname, currencyExchangeServicePort))
                .path(currencyExchangePath.orElse("/api/resources/exchange"));
    }

    @Retry(delay = 500, jitter = 150, maxRetries = 5, maxDuration = 3500)
    @Fallback(fallbackMethod = "fetchAllFallback")
    public List<Catalogue> fetchAll() {
        return entityManager
                .createNamedQuery("Catalogue.findAll", Catalogue.class)
                .getResultList();
    }

    private List<Catalogue> fetchAllFallback() {
        LOGGER.severe("Using fetchAllFallback");
        return Collections.emptyList();
    }

    private Catalogue fetchById(long id) {
        return entityManager
                .createNamedQuery("Catalogue.findById", Catalogue.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst()
                .orElse(new Catalogue());
    }

    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.2, delay = 1000L, successThreshold = 5)
    @Fallback(fallbackMethod = "fetchByIdPriceByCurrencyFallback")
    public Catalogue fetchByIdPriceByCurrency(long id, String currency) {
        Catalogue catalogue = fetchById(id);
        double price = catalogue.getPrice();

        if (currency != null && !currency.isEmpty()) {

            /*
            Response response = target
                    .queryParam("currency", currency)
                    .queryParam("value", catalogue.getPrice())
                    .request()
                    .get();

            JsonObject rawJsonResponse = response.readEntity(JsonObject.class);
             */

            JsonObject rawJsonResponse = currencyExchangeClient.getExchangeRate(currency, price);
            price = rawJsonResponse.getJsonNumber("newValue").doubleValue();
        }

        return new Catalogue(catalogue.getId(), catalogue.getBrand(), catalogue.getProduct(), price);
    }

    public Catalogue fetchByIdPriceByCurrencyFallback(long id, String currency) {
        LOGGER.severe(String.format("Using fetchByIdPriceByCurrencyFallback with id %d and currency %s", id, currency));
        return new Catalogue("", "", 0.0);
    }

    @PreDestroy
    void tearDown() {
        client.close();
    }
}
