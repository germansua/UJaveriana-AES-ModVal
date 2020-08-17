package co.edu.javeriana.pica.kubernetes.time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.time.Instant;

@Path("/timestamp")
public class TimestampResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTime() throws Exception {
        String hostName = InetAddress.getLocalHost().getHostName();
        return Instant.now().toString() + ", from: " + hostName;
    }
}