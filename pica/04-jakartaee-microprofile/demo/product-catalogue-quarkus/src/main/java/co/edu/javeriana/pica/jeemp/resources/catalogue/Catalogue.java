package co.edu.javeriana.pica.jeemp.resources.catalogue;

import javax.persistence.*;

@Entity
@Table(name = "CATALOGUE")
@NamedQueries({
        @NamedQuery(name = "Catalogue.findAll", query = "SELECT c FROM Catalogue c"),
        @NamedQuery(name = "Catalogue.findById", query = "SELECT c FROM Catalogue c WHERE c.id = :id")
})
public class Catalogue {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "PRODUCT")
    private String product;

    @Column(name = "PRICE")
    private double price;

    public Catalogue() {
    }

    public Catalogue(String brand, String product, double price) {
        this.brand = brand;
        this.product = product;
        this.price = price;
    }

    public Catalogue(long id, String brand, String product, double price) {
        this.id = id;
        this.brand = brand;
        this.product = product;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }
}
