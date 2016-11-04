
package co.edu.javeriana.aes.modval.pagos.artifacts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.edu.javeriana.aes.modval.pagos.artifacts package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReferenciaFactura_QNAME = new QName("http://www.servicios.co/pagos/schemas", "ReferenciaFactura");
    private final static QName _Resultado_QNAME = new QName("http://www.servicios.co/pagos/schemas", "Resultado");
    private final static QName _ResultadoConsulta_QNAME = new QName("http://www.servicios.co/pagos/schemas", "ResultadoConsulta");
    private final static QName _Pago_QNAME = new QName("http://www.servicios.co/pagos/schemas", "Pago");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.edu.javeriana.aes.modval.pagos.artifacts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferenciaFactura }
     * 
     */
    public ReferenciaFactura createReferenciaFactura() {
        return new ReferenciaFactura();
    }

    /**
     * Create an instance of {@link Resultado }
     * 
     */
    public Resultado createResultado() {
        return new Resultado();
    }

    /**
     * Create an instance of {@link ResultadoConsulta }
     * 
     */
    public ResultadoConsulta createResultadoConsulta() {
        return new ResultadoConsulta();
    }

    /**
     * Create an instance of {@link Pago }
     * 
     */
    public Pago createPago() {
        return new Pago();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenciaFactura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.servicios.co/pagos/schemas", name = "ReferenciaFactura")
    public JAXBElement<ReferenciaFactura> createReferenciaFactura(ReferenciaFactura value) {
        return new JAXBElement<ReferenciaFactura>(_ReferenciaFactura_QNAME, ReferenciaFactura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resultado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.servicios.co/pagos/schemas", name = "Resultado")
    public JAXBElement<Resultado> createResultado(Resultado value) {
        return new JAXBElement<Resultado>(_Resultado_QNAME, Resultado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoConsulta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.servicios.co/pagos/schemas", name = "ResultadoConsulta")
    public JAXBElement<ResultadoConsulta> createResultadoConsulta(ResultadoConsulta value) {
        return new JAXBElement<ResultadoConsulta>(_ResultadoConsulta_QNAME, ResultadoConsulta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.servicios.co/pagos/schemas", name = "Pago")
    public JAXBElement<Pago> createPago(Pago value) {
        return new JAXBElement<Pago>(_Pago_QNAME, Pago.class, null, value);
    }

}
