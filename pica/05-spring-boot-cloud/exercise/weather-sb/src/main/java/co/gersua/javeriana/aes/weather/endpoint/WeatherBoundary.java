package co.gersua.javeriana.aes.weather.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resources/weathersb")
public class WeatherBoundary {

    @Autowired
    @Qualifier("weatherControl")
    private WeatherService weatherService;

    @GetMapping
    public WeatherEntity getWeather(@RequestParam String location) {
        return weatherService.getWeather(location);
    }
}
