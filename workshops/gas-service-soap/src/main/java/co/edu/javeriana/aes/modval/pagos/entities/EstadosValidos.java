package co.edu.javeriana.aes.modval.pagos.entities;

public enum EstadosValidos {

    SIN_PAGAR(1),
    PENDIENTE(2),
    PAGADA(3);
    
    private final int value;
    
    private EstadosValidos(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
