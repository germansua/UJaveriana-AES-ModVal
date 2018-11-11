package co.edu.javeriana.aes.modval.pagos.exceptions;

public class FacturaInvalidaException extends RuntimeException {

    public FacturaInvalidaException() {
        super("Referencia de factura invalida");
    }
}
