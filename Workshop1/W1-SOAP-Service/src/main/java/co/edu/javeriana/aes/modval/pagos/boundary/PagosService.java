package co.edu.javeriana.aes.modval.pagos.boundary;

import co.edu.javeriana.aes.modval.pagos.artifacts.*;

import javax.jws.WebService;
import java.util.Random;

@WebService(endpointInterface = "co.edu.javeriana.aes.modval.pagos.artifacts.PagosInerface")
public class PagosService implements PagosInerface {

    @Override
    public ResultadoConsulta cosultar(ReferenciaFactura referenciaFactura) {

        ResultadoConsulta resultado = new ResultadoConsulta();
        resultado.setReferenciaFactura(new ReferenciaFactura(referenciaFactura.getReferenciaFactura()));
        resultado.setTotalPagar(new Random().nextDouble() * 100000);

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
