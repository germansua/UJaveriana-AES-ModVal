package co.edu.javeriana.aes.modaval.pagos.boundary;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.edu.javeriana.aes.modaval.pagos.artifacts.Pago;
import co.edu.javeriana.aes.modaval.pagos.artifacts.PagosInerface;
import co.edu.javeriana.aes.modaval.pagos.artifacts.ReferenciaFactura;
import co.edu.javeriana.aes.modaval.pagos.artifacts.Resultado;
import co.edu.javeriana.aes.modaval.pagos.artifacts.ResultadoConsulta;

@Stateless
@WebService(endpointInterface = "co.edu.javeriana.aes.modaval.pagos.artifacts.PagosInerface", serviceName = "Pagos")
public class PagosService implements PagosInerface{

    @Override
    public ResultadoConsulta cosultar(
            @WebParam(name = "ReferenciaFactura", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input") ReferenciaFactura input) {
        return new ResultadoConsulta();
    }

    @Override
    public Resultado pagar(
            @WebParam(name = "Pago", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input") Pago input) {
        return new Resultado();
    }

    @Override
    public Resultado compensar(
            @WebParam(name = "Pago", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input") Pago input) {
        return new Resultado();
    }
}
