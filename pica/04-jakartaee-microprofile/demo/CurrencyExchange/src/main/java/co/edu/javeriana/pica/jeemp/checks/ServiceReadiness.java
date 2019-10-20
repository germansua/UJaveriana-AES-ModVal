package co.edu.javeriana.pica.jeemp.checks;

import co.edu.javeriana.pica.jeemp.resources.exchange.ExchangeResource;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;

@Readiness
@ApplicationScoped
public class ServiceReadiness implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        int status =
                ClientBuilder
                        .newClient()
                        .target("http://localhost:8080/api/resources/exchange")
                        .request()
                        .get()
                        .getStatus();
        return HealthCheckResponse
                .named(ExchangeResource.class.getSimpleName() + ServiceReadiness.class.getSimpleName())
                .withData("Checking app response status code", status)
                .state(status == 200)
                .build();
    }
}
