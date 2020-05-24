package co.edu.javeriana.aes.pica.exchange;

import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeResource {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity<ExchangeResponse> getExchangeRate(@RequestParam("currency") String currency, @RequestParam("value") double value) {

        currency = currency != null ? currency : Currencies.USD.toString();
        String hostName = (String) Try.of(() -> InetAddress.getLocalHost().getHostName()).getOrElse("null");

        return ResponseEntity.ok(new ExchangeResponse(
                hostName,
                currency,
                exchangeService.exchangeUSDTo(currency, value)
        ));
    }
}
