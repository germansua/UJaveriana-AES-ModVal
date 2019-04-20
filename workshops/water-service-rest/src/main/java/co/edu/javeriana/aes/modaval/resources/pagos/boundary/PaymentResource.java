package co.edu.javeriana.aes.modaval.resources.pagos.boundary;

import co.edu.javeriana.aes.modaval.resources.pagos.entity.Factura;
import co.edu.javeriana.aes.modaval.resources.pagos.entity.Resultado;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("payments")
public class PaymentResource {

    @GET
    @Path("{idFactura}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Factura getInfoFactura(@PathParam("idFactura") int idFactura) {
        return new Factura(idFactura, new Random().nextDouble() * 100000);
    }

    @POST
    @Path("{idFactura}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Resultado pagarFactura(@PathParam("idFactura") int idFactura, Factura factura) {
        return new Resultado(idFactura, "Factura Pagada Exitosamente");
    }

    @DELETE
    @Path("{idFactura}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Resultado copensarFactura(@PathParam("idFactura") int idFactura) {
        return new Resultado(idFactura, "Factura Compensada Exitosamente");
    }
}
