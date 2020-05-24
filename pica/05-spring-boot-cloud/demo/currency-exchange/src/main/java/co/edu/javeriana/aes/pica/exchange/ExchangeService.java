package co.edu.javeriana.aes.pica.exchange;

import io.vavr.control.Try;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    public double exchangeUSDTo(String currency, double value) {
        Currencies toCurrency = Try.of(() -> Currencies.valueOf(currency)).getOrElse(Currencies.USD);
        return toCurrency.getRate() * value;
    }
}
