package co.edu.javeriana.aes.modval.boundary;

import co.edu.javeriana.aes.modval.control.Factura;

import javax.ws.rs.*;

@Path("facturacion")
public class FacturacionResoruce {
    
    @GET
    public Factura obtenerFactura(@QueryParam("referencia-pago") String referenciaPago) {
        return new Factura();
    }

    @POST
    public Factura pagarFactura(@QueryParam("referencia-pago") String referenciaPago) {
        return new Factura();
    }

    @PUT
    public Factura compensarFactura(@QueryParam("referencia-pago") String referenciaPago) {
        return new Factura();
    }
}
