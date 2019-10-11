package co.edu.javeriana.pica.frameworks.echo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resources/echo")
public class EchoResource {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public Echo echo(@RequestParam String message) {
        return new Echo(
                message != null ? message : "",
                timeService.getTime());
    }
}
