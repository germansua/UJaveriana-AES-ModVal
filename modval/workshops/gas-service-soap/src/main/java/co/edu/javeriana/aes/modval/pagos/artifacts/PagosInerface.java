
package co.edu.javeriana.aes.modval.pagos.artifacts;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PagosInerface", targetNamespace = "http://www.servicios.co/pagos/service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PagosInerface {


    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.ResultadoConsulta
     */
    @WebMethod(operationName = "Cosultar", action = "consultar")
    @WebResult(name = "ResultadoConsulta", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    public ResultadoConsulta cosultar(
        @WebParam(name = "ReferenciaFactura", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        ReferenciaFactura input);

    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.Resultado
     */
    @WebMethod(operationName = "Pagar", action = "pagar")
    @WebResult(name = "Resultado", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    public Resultado pagar(
        @WebParam(name = "PagoResource", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        Pago input);

    /**
     * 
     * @param input
     * @return
     *     returns co.edu.javeriana.aes.modval.pagos.artifacts.Resultado
     */
    @WebMethod(operationName = "Compensar", action = "compensar")
    @WebResult(name = "Resultado", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
    public Resultado compensar(
        @WebParam(name = "PagoResource", targetNamespace = "http://www.servicios.co/pagos/schemas", partName = "Input")
        Pago input);

}