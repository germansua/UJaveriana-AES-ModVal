package co.edu.javeriana.pica.kubernetes.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    TimestampServiceClient timestampServiceClient;

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        return "Hello! The time is: " + timestampServiceClient.getTime();
    }
}