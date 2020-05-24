package co.edu.javeriana.aes.pica.catalogue;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("CURRENCY-EXCHANGE")
@RequestMapping("/api/exchange")
public interface CurrencyExchangeClient {

    @GetMapping
    ExchangeResponse getExchangeRate(@RequestParam("currency") String currency, @RequestParam("value") double value);
}
