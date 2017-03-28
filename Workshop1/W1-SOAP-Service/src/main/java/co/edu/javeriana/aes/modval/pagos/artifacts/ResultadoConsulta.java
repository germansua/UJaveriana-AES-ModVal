
package co.edu.javeriana.aes.modval.pagos.artifacts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultadoConsulta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultadoConsulta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referenciaFactura" type="{http://www.servicios.co/pagos/schemas}ReferenciaFactura"/>
 *         &lt;element name="totalPagar" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultadoConsulta", propOrder = {
    "referenciaFactura",
    "totalPagar"
})
public class ResultadoConsulta {

    @XmlElement(required = true)
    protected ReferenciaFactura referenciaFactura;
    protected double totalPagar;

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
     * Gets the value of the totalPagar property.
     * 
     */
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * Sets the value of the totalPagar property.
     * 
     */
    public void setTotalPagar(double value) {
        this.totalPagar = value;
    }

}
