package co.edu.javeriana.pica.sbsc.resources.exchange;

public enum Currencies {

    USD(1.0),
    GBP(0.78),
    EUR(0.91),
    COP(3423.51);

    private double rate;

    Currencies(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
