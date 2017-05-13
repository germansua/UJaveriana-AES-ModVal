package co.edu.javeriana.aes.modval.helloworld.boundary;

import co.edu.javeriana.aes.modval.helloworld.control.HelloWorldService;
import co.edu.javeriana.aes.modval.helloworld.entity.HelloWorld;
import co.edu.javeriana.aes.modval.helloworld.entity.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * This class represents the resource. It is also consider the boundary or protocol adaptor.
 * In this case an adaptor to a REST like service
 * */
@RestController
@RequestMapping("api/resources")
public class HelloWorldResource {

    private static final String TS_SERVER = "timestamp";
    private static final int TS_PORT = 8080;
    private static String TS_URL = String.format("http://%s:%d/api/resources/ts", TS_SERVER, TS_PORT);

    /* RestTemplete is the Spring object that allows us to compose other services */
    private RestTemplate template = new RestTemplate();

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(method = RequestMethod.GET, value = "hw",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public HelloWorld sayHello() {
        /* New template that request and consumes the timestamp service */
        Timestamp timestamp = template.getForObject(TS_URL, Timestamp.class);

        /* Returns the composition between the greeting and the timestamp service */
        return helloWorldService.getGreeting(timestamp.getCurrentTS());
    }
}
