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
public class RespuestaPagoOK extends RespuestaPago{
    
    private String mensajeOK;

    /**
     * @return the mensajeOK
     */
    public String getMensajeOK() {
        return mensajeOK;
    }

    /**
     * @param mensajeOK the mensajeOK to set
     */
    public void setMensajeOK(String mensajeOK) {
        this.mensajeOK = mensajeOK;
    }
    
}
