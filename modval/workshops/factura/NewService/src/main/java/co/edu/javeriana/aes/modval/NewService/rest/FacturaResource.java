package co.edu.javeriana.aes.modval.NewService.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;


@Path("/factura")
public class FacturaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Factura infoFactura(@QueryParam("fid") String fid) {
        if (!fid.startsWith("ABCD")) {
            throw new IllegalArgumentException("Factura Invalida");
        }
        return new Factura(fid, LocalDate.now(), new InfoPago(63721.23, EstadoFactura.PENDIENTE));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Factura pagarFactura(Factura factura) {
        if (!factura.getFid().startsWith("ABCD")) {
            throw new IllegalArgumentException("Factura Invalida");
        }
        return new Factura(factura.getFid(), LocalDate.now(), new InfoPago(63721.23, EstadoFactura.PAGADA));
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public Factura compensarFactura(Factura factura) {
        if (!factura.getFid().startsWith("ABCD")) {
            throw new IllegalArgumentException("Factura Invalida");
        }
        return new Factura(factura.getFid(), LocalDate.now(), new InfoPago(63721.23, EstadoFactura.PENDIENTE));
    }
}
