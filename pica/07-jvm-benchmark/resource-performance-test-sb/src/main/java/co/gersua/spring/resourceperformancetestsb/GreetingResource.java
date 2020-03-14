package co.gersua.spring.resourceperformancetestsb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingResource {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "hello";
    }
}
