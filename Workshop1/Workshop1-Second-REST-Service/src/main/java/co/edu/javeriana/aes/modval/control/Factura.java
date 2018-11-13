package co.edu.javeriana.aes.modval.control;

public class Factura {
    
    public enum FacturaEstados {
        PAGADA,
        SIN_PAGAR;
    }
    
    private String referenciaPago;
    private Double valorReferencia;
    private FacturaEstados estadoReferencia;

    public Factura() {
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
