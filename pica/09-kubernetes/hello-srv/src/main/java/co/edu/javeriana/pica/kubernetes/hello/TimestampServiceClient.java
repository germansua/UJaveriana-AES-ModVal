package co.edu.javeriana.pica.kubernetes.hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "timestamp", url = "http://timestamp-service:8080")
@RequestMapping("/timestamp")
public interface TimestampServiceClient {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    String getTime();
}
