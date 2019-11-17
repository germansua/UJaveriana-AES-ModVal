package co.gersua.javeriana.aes.quickfatcs.rest;

public class QuickFactsModel {

    private String location;
    private String summary;
    private double weather;

    public QuickFactsModel(String location, String summary, double weather) {
        this.location = location;
        this.summary = summary;
        this.weather = weather;
    }

    public String getLocation() {
        return location;
    }

    public String getSummary() {
        return summary;
    }

    public double getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "QuickFactsModel{" +
                "location='" + location + '\'' +
                ", summary='" + summary + '\'' +
                ", weather=" + weather +
                '}';
    }
}
