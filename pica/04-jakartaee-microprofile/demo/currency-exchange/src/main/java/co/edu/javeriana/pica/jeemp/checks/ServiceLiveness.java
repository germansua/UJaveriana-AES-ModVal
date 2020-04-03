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

        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");

        return HealthCheckResponse
                .named(ExchangeResource.class.getSimpleName() + ServiceLiveness.class.getSimpleName())
                .withData("java.version", javaVersion)
                .withData("java.vendor", javaVendor)
                .withData("os.name", osName)
                .withData("os.version", osVersion)
                .withData("Available Processors", availableProcessors)
                .withData("Available Memory", memAvailable)
                .withData("Used Memory", memUsed)
                .withData("Max Memory", memMax)
                .withData("Memory Utilisation ", (memUsed / memMax) * 100)
                .state(memUsed / memMax < 0.9)
                .build();
    }
}
