package co.edu.javeriana.pica.sbsc.resources.exchange;

public class CurrencyExchangeModel {

    private String to;
    private double newValue;

    public CurrencyExchangeModel(String to, double newValue) {
        this.to = to;
        this.newValue = newValue;
    }

    public String getTo() {
        return to;
    }

    public double getNewValue() {
        return newValue;
    }
}
