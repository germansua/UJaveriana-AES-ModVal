package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class CustomerContactInfo {

    @Email
    private String email;
    private PhoneNumber phoneNumber;
    private Address address;

    public CustomerContactInfo(@Email String email, PhoneNumber phoneNumber, Address address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
