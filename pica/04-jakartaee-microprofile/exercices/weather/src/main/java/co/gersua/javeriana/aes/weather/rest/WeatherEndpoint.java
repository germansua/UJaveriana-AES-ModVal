package co.gersua.javeriana.aes.weather.rest;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("weather")
public class WeatherEndpoint {

    @GET
    @Timed(name = "WeatherEndpoint.getWeatherTime")
    @Counted(name = "WeatherEndpoint.getWeatherCount")
    @Produces({
            MediaType.APPLICATION_JSON,
            MediaType.TEXT_PLAIN
    })
    public WeatherModel getWeather(@QueryParam("location") String loc) {
        return new WeatherModel(loc, 12.05);
    }
}
