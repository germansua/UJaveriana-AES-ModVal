package co.edu.javeriana.aes.modval.NewService.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Factura implements Serializable {

    private String fid;
    private String fecha_pago;
    private InfoPago info_pago;

    public Factura() {
    }

    public Factura(String fid, LocalDate fecha_pago, InfoPago info_pago) {
        this.fid = fid;
        this.fecha_pago = fecha_pago.toString();
        this.info_pago = info_pago;
    }

    public String getFid() {
        return fid;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public InfoPago getInfo_pago() {
        return info_pago;
    }
}
