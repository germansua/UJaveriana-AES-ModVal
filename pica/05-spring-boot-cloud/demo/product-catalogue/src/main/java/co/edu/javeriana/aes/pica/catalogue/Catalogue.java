package co.edu.javeriana.aes.pica.catalogue;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CATALOGUE")
public class Catalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "PRODUCT")
    private String product;
    @Column(name = "PRICE")
    private double price;
}
