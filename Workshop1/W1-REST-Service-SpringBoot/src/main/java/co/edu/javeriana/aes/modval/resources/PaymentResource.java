package co.edu.javeriana.aes.modval.resources;

import co.edu.javeriana.aes.modval.entities.Factura;
import co.edu.javeriana.aes.modval.entities.Resultado;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Random;

@RestController
@RequestMapping("servicios/pagos/v1")
public class PaymentResource {

    @RequestMapping(path = "payments/{idFactura}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Factura getInfoFactura(@PathVariable("idFactura") int idFactura) {
        return new Factura(idFactura, new Random().nextDouble() * 100000);
    }

    @RequestMapping(path = "payments/{idFactura}", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Resultado pagarFactura(@PathParam("idFactura") int idFactura, Factura factura) {
        return new Resultado(idFactura, "Factura Pagada Exitosamente");
    }

    @RequestMapping(path = "payments/{idFactura}", method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Resultado copensarFactura(@PathParam("idFactura") int idFactura) {
        return new Resultado(idFactura, "Factura Compensada Exitosamente");
    }
}