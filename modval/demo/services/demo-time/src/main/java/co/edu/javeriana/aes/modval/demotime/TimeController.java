package co.edu.javeriana.aes.modval.demotime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTime() {
        return String.valueOf(System.currentTimeMillis());
    }
}
