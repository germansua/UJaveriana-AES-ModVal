package co.edu.javeriana.pica.jeemp.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("catalogue")
public class CatalogueResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogue> getAll() {
        return Collections.emptyList();
    }

    @GET
    @Path("{id}")
    public Catalogue get(@PathParam("id") long id) {
        return new Catalogue("brand", "product", 10);
    }
}
