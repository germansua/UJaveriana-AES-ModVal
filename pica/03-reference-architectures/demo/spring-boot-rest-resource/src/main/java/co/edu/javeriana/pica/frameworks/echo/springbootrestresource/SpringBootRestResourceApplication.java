package co.edu.javeriana.pica.frameworks.echo.springbootrestresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"co.edu.javeriana.pica.frameworks.echo.resources"
})
public class SpringBootRestResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestResourceApplication.class, args); }
}
