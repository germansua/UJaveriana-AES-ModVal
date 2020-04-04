package co.edu.javeriana.pica.jeemp.resources.catalogue;

import org.eclipse.microprofile.opentracing.Traced;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("catalogue")
public class CatalogueResource {

    @Inject
    private CatalogueService catalogueService;

    @GET
    @Traced
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogue> getAll() {
        return catalogueService.fetchAll();
    }

    @GET
    @Traced
    @Path("{id}")
    public Catalogue get(@PathParam("id") long id, @QueryParam("currency") String currency) {
        return catalogueService.fetchByIdPriceByCurrency(id, currency);
    }
}
