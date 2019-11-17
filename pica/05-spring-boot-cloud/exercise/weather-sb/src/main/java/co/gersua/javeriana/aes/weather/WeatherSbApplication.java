package co.gersua.javeriana.aes.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
		"co.gersua.javeriana.aes.weather.endpoint"
})
@SpringBootApplication
public class WeatherSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSbApplication.class, args);
	}
}
