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
public class RespuestaPagoError extends RespuestaPago{
    
    private String mensajeBad;

    /**
     * @return the mensajeBad
     */
    public String getMensajeBad() {
        return mensajeBad;
    }

    /**
     * @param mensajeBad the mensajeBad to set
     */
    public void setMensajeBad(String mensajeBad) {
        this.mensajeBad = mensajeBad;
    }
    
    
    
}
