package co.edu.javeriana.aes.modval.boundary;

import co.edu.javeriana.aes.modval.control.Factura;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("facturacion")
public class FacturacionResoruce {
    
    @GET
    @Path("{referencia-pago}")
    public Factura getFactura(@PathParam("referencia-pago") String referenciaPago) {
        return new Factura();
    }
}
