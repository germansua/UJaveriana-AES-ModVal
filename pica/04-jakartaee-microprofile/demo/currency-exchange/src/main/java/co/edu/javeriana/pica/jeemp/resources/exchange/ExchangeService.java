package co.edu.javeriana.pica.jeemp.resources.exchange;

import io.vavr.control.Try;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExchangeService {

    public double exchangeUSDTo(String currency, double value) {
        Currencies toCurrency = Try.of(() -> Currencies.valueOf(currency)).getOrElse(Currencies.USD);
        return toCurrency.getRate() * value;
    }
}
