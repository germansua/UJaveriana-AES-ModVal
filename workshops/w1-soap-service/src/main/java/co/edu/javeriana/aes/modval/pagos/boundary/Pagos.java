package co.edu.javeriana.aes.modval.pagos.boundary;

import co.edu.javeriana.aes.modval.pagos.artifacts.*;
import co.edu.javeriana.aes.modval.pagos.control.FacturasControl;
import co.edu.javeriana.aes.modval.pagos.entities.Facturas;
import co.edu.javeriana.aes.modval.pagos.exceptions.FacturaInvalidaException;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(endpointInterface = "co.edu.javeriana.aes.modval.pagos.artifacts.PagosInerface")
public class Pagos implements PagosInerface {

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
    public Resultado pagar(Pago pago) throws FacturaInvalidaException {
        ResultadoConsulta resultadoConsulta = cosultar(pago.getReferenciaFactura());
        Resultado resultado = new Resultado();
        resultado.setReferenciaFactura(pago.getReferenciaFactura());
        
        if (control.pagarFactura(resultadoConsulta.getReferenciaFactura().getReferenciaFactura())) {
            resultado.setMensaje("Factura Pagada Exitosamente");
        } else {
            resultado.setMensaje("Hubo un problema durante el pago de la factura");
        }
        
        return resultado;
    }

    @Override
    public Resultado compensar(Pago pago) throws FacturaInvalidaException {
        ResultadoConsulta resultadoConsulta = cosultar(pago.getReferenciaFactura());
        Resultado resultado = new Resultado();
        resultado.setReferenciaFactura(pago.getReferenciaFactura());
        
        if (control.compensarFactura(resultadoConsulta.getReferenciaFactura().getReferenciaFactura())) {
            resultado.setMensaje("Factura Compensada Exitosamente");
        } else {
            resultado.setMensaje("Hubo un problema durante el pago de la factura");
        }
        
        return resultado;
    }
}
