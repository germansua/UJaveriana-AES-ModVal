/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patrones.software.serviciorest.modelo;

/**
 *
 * @author sebastianpacheco
 */
public class RespuestaConsulta {
    
    private int idFactura;
    
    private int valorFactura;

    /**
     * @return the idFactura
     */
    public int getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the valorFactura
     */
    public int getValorFactura() {
        return valorFactura;
    }

    /**
     * @param valorFactura the valorFactura to set
     */
    public void setValorFactura(int valorFactura) {
        this.valorFactura = valorFactura;
    }
}
