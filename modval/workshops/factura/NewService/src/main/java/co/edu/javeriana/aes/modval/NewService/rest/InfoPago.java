package co.edu.javeriana.aes.modval.NewService.rest;

import java.io.Serializable;

public class InfoPago implements Serializable {

    private double valor;
    private EstadoFactura estado;

    public InfoPago() {
    }

    public InfoPago(double valor, EstadoFactura estado) {
        this.valor = valor;
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public EstadoFactura getEstado() {
        return estado;
    }
}
