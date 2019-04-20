package co.edu.javeriana.aes.modval.pagos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Estados")
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
})
public class Estados implements Serializable {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @NotNull
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadosValidos estado;

    public Estados() {
    }

    public Estados(EstadosValidos estado) {
        this.id = estado.getValue();
        this.estado = estado;
    }
    
    public int getId() {
        return id;
    }

    public EstadosValidos getEstado() {
        return estado;
    }
}
