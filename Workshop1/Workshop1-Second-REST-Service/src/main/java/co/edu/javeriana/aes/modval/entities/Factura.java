package co.edu.javeriana.aes.modval.entities;

public class Factura {
    
    public enum FacturaEstados {
        PAGADA,
        SIN_PAGAR;
    }
    
    private String referenciaPago;
    private Double valorReferencia;
    private FacturaEstados estadoReferencia;

    public Factura(String referenciaPago, Double valorReferencia, FacturaEstados estadoReferencia) {
        this.referenciaPago = referenciaPago;
        this.valorReferencia = valorReferencia;
        this.estadoReferencia = estadoReferencia;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public Double getValorReferencia() {
        return valorReferencia;
    }

    public FacturaEstados getEstadoReferencia() {
        return estadoReferencia;
    }
}
