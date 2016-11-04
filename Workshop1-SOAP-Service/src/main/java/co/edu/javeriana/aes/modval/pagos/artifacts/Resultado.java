
package co.edu.javeriana.aes.modval.pagos.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Resultado complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Resultado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referenciaFactura" type="{http://www.servicios.co/pagos/schemas}ReferenciaFactura"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resultado", propOrder = {
    "referenciaFactura",
    "mensaje"
})
public class Resultado {

    @XmlElement(required = true)
    protected ReferenciaFactura referenciaFactura;
    @XmlElement(required = true)
    protected String mensaje;

    /**
     * Gets the value of the referenciaFactura property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenciaFactura }
     *     
     */
    public ReferenciaFactura getReferenciaFactura() {
        return referenciaFactura;
    }

    /**
     * Sets the value of the referenciaFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenciaFactura }
     *     
     */
    public void setReferenciaFactura(ReferenciaFactura value) {
        this.referenciaFactura = value;
    }

    /**
     * Gets the value of the mensaje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets the value of the mensaje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

}
