package co.gersua.javeriana.aes.weather.rest;

public final class WeatherModel {

    private String location;
    private double temperature;

    public WeatherModel(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "location='" + location + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
