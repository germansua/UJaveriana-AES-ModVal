package co.edu.javeriana.aes.pica.catalogue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CatalogueService {

    @Autowired
    CatalogueRepository catalogueRepository;

    @Autowired
    CurrencyExchangeClient currencyExchangeClient;

    public List<Catalogue> fetchAll() {
        return catalogueRepository.findAll();
    }

    private Optional<Catalogue> fetchById(long id) {
        return catalogueRepository.findById(id);
    }

    public Catalogue fetchByIdPriceByCurrency(long id, String currency) throws ProductNotFoundInCatalogueException {
        var catalogueOptional = fetchById(id);
        var catalogue = catalogueOptional
                .orElseThrow(() -> new ProductNotFoundInCatalogueException(id));
        var price = catalogue.getPrice();
        var exchangeRate = currencyExchangeClient.getExchangeRate(currency, price);
        log.info("currency exchange host: {}", exchangeRate.getHost());
        return new Catalogue(catalogue.getId(), catalogue.getBrand(), catalogue.getProduct(), exchangeRate.getNewValue());
    }
}
