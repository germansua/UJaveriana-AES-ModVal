package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import lombok.Data;

@Data
public class Address {

    public enum AddressType {
        HOME, OFFICE;
    }

    private String countryCode;
    private String city;
    private String number;
    private PostalCode postalCode;

    public Address(String countryCode, String city, String number) {
        this.countryCode = countryCode;
        this.city = city;
        this.number = number;
    }
}
