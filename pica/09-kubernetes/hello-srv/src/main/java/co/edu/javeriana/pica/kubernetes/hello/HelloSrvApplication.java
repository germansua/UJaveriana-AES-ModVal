package co.edu.javeriana.pica.kubernetes.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HelloSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSrvApplication.class, args);
	}
}
