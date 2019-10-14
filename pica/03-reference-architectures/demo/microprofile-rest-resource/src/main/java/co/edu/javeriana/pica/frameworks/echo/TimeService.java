package co.edu.javeriana.pica.frameworks.echo;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

@ApplicationScoped
public class TimeService {

    public Instant getTime() {
        return Instant.now();
    }
}
