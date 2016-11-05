package co.edu.javeriana.aes.modaval.resources.pagos.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Factura {

    private int idFactura;
    private double valorFactura;

    public Factura() {
    }

    public Factura(double valorFactura) {
        this.valorFactura = valorFactura;
    }

    public Factura(int idFactura, double valorFactura) {
        this.idFactura = idFactura;
        this.valorFactura = valorFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }
}
