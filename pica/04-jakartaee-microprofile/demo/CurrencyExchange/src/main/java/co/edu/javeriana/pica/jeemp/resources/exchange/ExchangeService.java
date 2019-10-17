package co.edu.javeriana.pica.jeemp.resources.exchange;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExchangeService {

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
