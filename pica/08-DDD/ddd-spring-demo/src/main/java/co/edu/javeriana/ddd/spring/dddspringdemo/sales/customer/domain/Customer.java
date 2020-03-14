package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ValidCustomer
public class Customer {

    @NotNull
    private int id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String firstName;

    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    private String lastName;

    @NotNull
    private CustomerContactInfo contactInfo;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String firstName, String lastName, CustomerContactInfo contactInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }
}
