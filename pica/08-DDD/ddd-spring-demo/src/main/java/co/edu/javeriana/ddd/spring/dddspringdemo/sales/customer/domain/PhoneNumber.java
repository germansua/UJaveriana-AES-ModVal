package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PhoneNumber {

    public enum PhoneNumberType {
        CELLPHONE, HOME, OFFICE;
    }

    private PhoneNumberType type;
    private String countryCode;
    private short localCode;
    private int number;

    public PhoneNumber(PhoneNumberType type, String countryCode, short localCode, int number) {
        this.type = type;
        this.countryCode = countryCode;
        this.localCode = localCode;
        this.number = number;
    }
}
