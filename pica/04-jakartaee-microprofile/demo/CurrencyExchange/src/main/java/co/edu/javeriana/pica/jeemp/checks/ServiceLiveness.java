package co.edu.javeriana.pica.jeemp.checks;

import co.edu.javeriana.pica.jeemp.resources.exchange.ExchangeResource;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Liveness
@ApplicationScoped
public class ServiceLiveness implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memoryBean.getHeapMemoryUsage().getUsed();
        long memMax = memoryBean.getHeapMemoryUsage().getMax();
        long memAvailable = Runtime.getRuntime().freeMemory();
        long availableProcessors = Runtime.getRuntime().availableProcessors();

        return HealthCheckResponse
                .named(ExchangeResource.class.getSimpleName())
                .withData("Available Processors", availableProcessors)
                .withData("Available Memory", memAvailable)
                .withData("Used Memory", memUsed)
                .withData("Max Memory", memMax)
                .state(memUsed / memMax < 0.9)
                .build();
    }
}
