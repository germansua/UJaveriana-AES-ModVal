package co.edu.javeriana.aes.modval.pagos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Facturas")
@NamedQueries({
    @NamedQuery(name = "Facturas.findByReferencia", query = "SELECT f FROM Facturas f WHERE f.referencia = :referencia")
})
public class Facturas implements Serializable {

    @Id
    @Column(name = "referencia")
    @NotNull
    private String referencia;

    @NotNull
    @Column(name = "valor")
    private Double valor;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultima_modification")
    private Date ultimaModification;

    @NotNull
    @JoinColumn(name = "estado_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Estados estado;

    public String getReferencia() {
        return referencia;
    }

    public Double getValor() {
        return valor;
    }

    public Date getUltimaModification() {
        return ultimaModification;
    }

    public void setUltimaModification(Date ultimaModification) {
        this.ultimaModification = ultimaModification;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
