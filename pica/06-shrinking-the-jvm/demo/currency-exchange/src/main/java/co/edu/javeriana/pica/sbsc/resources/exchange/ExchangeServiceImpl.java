package co.edu.javeriana.pica.sbsc.resources.exchange;

import org.springframework.stereotype.Component;

@Component
public class ExchangeServiceImpl implements ExchangeService {

    public double exchangeUSDTo(String currency, double value) {
        Currencies toCurrency;
        try {
            toCurrency = Currencies.valueOf(currency);
        } catch (IllegalArgumentException ex) {
            toCurrency = Currencies.USD;
        }

        return toCurrency.getRate() * value;
    }
}
