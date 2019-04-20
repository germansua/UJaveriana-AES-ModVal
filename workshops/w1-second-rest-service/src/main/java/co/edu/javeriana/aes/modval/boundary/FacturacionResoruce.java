package co.edu.javeriana.aes.modval.boundary;

import co.edu.javeriana.aes.modval.control.FacturaControl;
import co.edu.javeriana.aes.modval.entities.Factura;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("facturacion")
public class FacturacionResoruce {

    @Inject
    private FacturaControl control;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Factura obtenerFactura(@QueryParam("referencia-pago") @NotNull String referenciaPago) {
        return new Factura(referenciaPago, new Random().nextDouble() * 100000, Factura.FacturaEstados.SIN_PAGAR);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Factura pagarFactura(@QueryParam("referencia-pago") @NotNull String referenciaPago) {
        return new Factura(referenciaPago, new Random().nextDouble() * 100000, Factura.FacturaEstados.PAGADA);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Factura compensarFactura(@QueryParam("referencia-pago") @NotNull String referenciaPago) {
        return new Factura(referenciaPago, new Random().nextDouble() * 100000, Factura.FacturaEstados.SIN_PAGAR);
    }
}
