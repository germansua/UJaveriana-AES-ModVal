package co.edu.javeriana.pica.sbsc.checks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Component
public class ServiceLiveness implements HealthIndicator {

    @Override
    public Health health() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memoryBean.getHeapMemoryUsage().getUsed();
        long memMax = memoryBean.getHeapMemoryUsage().getMax();

        long memAvailable = Runtime.getRuntime().freeMemory();
        long availableProcessors = Runtime.getRuntime().availableProcessors();

        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");

        return Health
                .status(memUsed / memMax < 0.9 ? Status.UP : Status.DOWN)
                .withDetail("java.version", javaVersion)
                .withDetail("java.vendor", javaVendor)
                .withDetail("os.name", osName)
                .withDetail("os.version", osVersion)
                .withDetail("Available Processors", availableProcessors)
                .withDetail("Available Memory", memAvailable)
                .withDetail("Used Memory", memUsed)
                .withDetail("Max Memory", memMax)
                .withDetail("Memory Utilisation ", (memUsed / memMax) * 100)
                .build();
    }
}
