package co.edu.javeriana.pica.frameworks.echo;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("echo")
public class EchoResource {

    @Inject
    private TimeService timeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject echo(@QueryParam("message") String message) {
        return Json.createObjectBuilder()
                .add("message", message != null ? message : "")
                .add("time", timeService.getTime().toString())
                .build();
    }
}
