package co.edu.javeriana.pica.sbsc.resources.exchange;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resources/exchange")
public class ExchangeResource {

    @Autowired
    private ExchangeService exchangeService;

    @HystrixCommand(fallbackMethod = "getExchangeRateFallback")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyExchangeModel getExchangeRate(@RequestParam String currency, @RequestParam double value) {
        currency = currency != null ? currency : Currencies.USD.toString();
        double convertedValue = exchangeService.exchangeUSDTo(currency, value);
        return new CurrencyExchangeModel(currency, convertedValue);
    }

    public CurrencyExchangeModel getExchangeRateFallback(@RequestParam String currency, @RequestParam double value) {
        return new CurrencyExchangeModel(currency, 0.0);
    }
}
