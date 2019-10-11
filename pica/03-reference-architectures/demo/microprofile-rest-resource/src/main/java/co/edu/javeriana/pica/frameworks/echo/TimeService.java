package co.edu.javeriana.pica.frameworks.echo;

import javax.enterprise.context.RequestScoped;
import java.time.Instant;

@RequestScoped
public class TimeService {

    public Instant getTime() {
        return Instant.now();
    }
}
