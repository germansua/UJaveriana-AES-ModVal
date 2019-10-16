package co.edu.javeriana.pica.jeemp.resources;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Catalogue.findAll", query = "SELECT c FROM Catalogue c"),
        @NamedQuery(name = "Catalogue.findById", query = "SELECT c FROM Catalogue c WHERE c.id = :id")
})
public class Catalogue {

    @Id
    private long id;
    private String brand;
    private String product;
    private double price;

    public Catalogue(String brand, String product, double price) {
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
