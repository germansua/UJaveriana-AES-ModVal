package co.edu.javeriana.pica.frameworks.echo.resources;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimeServiceImpl implements TimeService {

    @Override
    public String getTime() {
        return Instant.now().toString();
    }
}
