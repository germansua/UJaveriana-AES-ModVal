/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patrones.software.serviciorest.recursos;

import com.patrones.software.serviciorest.modelo.PeticionPago;
import com.patrones.software.serviciorest.modelo.RespuestaConsulta;
import com.patrones.software.serviciorest.modelo.RespuestaPagoError;
import com.patrones.software.serviciorest.modelo.RespuestaPagoOK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Logger log = LoggerFactory.getLogger(RestController.class);

    @RequestMapping(value = "/payments/{factura}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity consultarValor(@PathVariable Integer factura) {
        log.info(String.format("Get Service Invoked with idFactura %s", factura));
        if (factura == null || factura.equals(Integer.valueOf(0))) {
            return (ResponseEntity) ResponseEntity.status(404);
        } else if (factura > 100) {
            RespuestaConsulta respuestaConsulta = new RespuestaConsulta();
            respuestaConsulta.setIdFactura(factura);
            respuestaConsulta.setValorFactura(150000);
            return ResponseEntity.ok(respuestaConsulta);
        }
        return ResponseEntity.status(404).build();
    }

    @RequestMapping(value = "/payments/{factura}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity pagarFactura(@PathVariable Integer factura, @RequestBody PeticionPago peticionPago) {
        log.info(String.format("Pagando el servicio con id de factura %d con valor %d", factura, peticionPago.getValorFactura()));
        if ( peticionPago.getValorFactura() == 0) {
            return ResponseEntity.status(404).body("No se recibió el valor de la factura");
        } else if (factura > 100) {
            RespuestaPagoOK respuesta = new RespuestaPagoOK();
            respuesta.setIdFactura(factura);
            respuesta.setMensajeOK("Pago procesado");
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaPagoError respuesta = new RespuestaPagoError();
            respuesta.setIdFactura(factura);
            respuesta.setMensajeBad("Factura no encontrada");
            return ResponseEntity.status(404).body(respuesta);
        }
    }
    
    @RequestMapping(value = "/payments/{factura}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity compensarFactura(@PathVariable Integer factura, @RequestBody PeticionPago peticionPago) {
        log.info(String.format("Compensando el servicio con id de factura %d con valor %d", factura, peticionPago.getValorFactura()));
        if ( peticionPago.getValorFactura() == 0) {
            return ResponseEntity.status(404).body("No se recibió el valor de la factura");
        } else if (factura > 100) {
            RespuestaPagoOK respuesta = new RespuestaPagoOK();
            respuesta.setIdFactura(factura);
            respuesta.setMensajeOK("Factura compensada");
            return ResponseEntity.ok(respuesta);
        } else {
            RespuestaPagoError respuesta = new RespuestaPagoError();
            respuesta.setIdFactura(factura);
            respuesta.setMensajeBad("Factura no encontrada");
            return ResponseEntity.status(404).body(respuesta);
        }
    }

}
