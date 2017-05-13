package co.edu.javeriana.aes.modval.helloworld.control;

import co.edu.javeriana.aes.modval.helloworld.entity.HelloWorld;
import org.springframework.stereotype.Service;

/**
 * This class represents the actual service that generates the greeting message
 */
@Service
public class HelloWorldService {

    public HelloWorld getGreeting(long timestamp) {
        return new HelloWorld(String.format("%s at %d", "Hello World", timestamp));
    }
}
