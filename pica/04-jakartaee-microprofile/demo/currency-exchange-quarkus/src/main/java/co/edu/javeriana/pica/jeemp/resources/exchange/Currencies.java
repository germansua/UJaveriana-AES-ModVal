package co.edu.javeriana.pica.jeemp.resources.exchange;

public enum Currencies {

    USD(1.0),
    GBP(0.81),
    EUR(0.93),
    COP(4025);

    private double rate;

    Currencies(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
