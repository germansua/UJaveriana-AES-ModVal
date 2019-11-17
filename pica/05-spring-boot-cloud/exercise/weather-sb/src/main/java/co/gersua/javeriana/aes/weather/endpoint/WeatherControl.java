package co.gersua.javeriana.aes.weather.endpoint;

import org.springframework.stereotype.Component;

@Component
public class WeatherControl implements WeatherService {

    public WeatherEntity getWeather(String location) {
        if (location.equals("BOG")){
            return new WeatherEntity(location, 12.5);
        } else if (location.equals("CAR")) {
            return new WeatherEntity(location, 32.2);
        }
        return new WeatherEntity(location, 0.0);
    }
}
