package co.edu.javeriana.aes.modaval.resources.pagos.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Resultado {

    protected int idFactura;
    protected String mensaje;

    public Resultado() {
    }

    public Resultado(int idFactura, String mensaje) {
        this.idFactura = idFactura;
        this.mensaje = mensaje;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
