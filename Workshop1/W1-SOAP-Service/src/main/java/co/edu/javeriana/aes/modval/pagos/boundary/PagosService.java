package co.edu.javeriana.aes.modval.pagos.boundary;

import co.edu.javeriana.aes.modval.pagos.artifacts.*;
import co.edu.javeriana.aes.modval.pagos.control.FacturasControl;
import co.edu.javeriana.aes.modval.pagos.entities.Facturas;
import co.edu.javeriana.aes.modval.pagos.exceptions.FacturaInvalidaException;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(endpointInterface = "co.edu.javeriana.aes.modval.pagos.artifacts.PagosInerface")
public class PagosService implements PagosInerface {

    @Inject
    private FacturasControl control;

    @Override
    public ResultadoConsulta cosultar(ReferenciaFactura referenciaFactura) throws FacturaInvalidaException {
        Facturas factura = control.getFacturaByReferencia(referenciaFactura.getReferenciaFactura());

        if (factura == null) {
            throw new FacturaInvalidaException();
        }

        ResultadoConsulta resultado = new ResultadoConsulta();
        resultado.setReferenciaFactura(new ReferenciaFactura(factura.getReferencia()));
        resultado.setTotalPagar(factura.getValor());

        return resultado;
    }

    @Override
    public Resultado pagar(Pago pago) {

        Resultado resultado = new Resultado();
        resultado.setReferenciaFactura( pago.getReferenciaFactura() );
        resultado.setMensaje("Factura Pagada Exitosamente");

        return resultado;
    }

    @Override
    public Resultado compensar(Pago pago) {

        Resultado resultado = new Resultado();
        resultado.setReferenciaFactura( pago.getReferenciaFactura() );
        resultado.setMensaje("Compensado Exitosamente");

        return resultado;
    }
}
