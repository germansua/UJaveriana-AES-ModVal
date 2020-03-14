package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Data
@Setter(AccessLevel.NONE)
public class PostalCode {

    @Pattern(regexp = "[0-9]{6}")
    private String number;

    public PostalCode(@Pattern(regexp = "[0-9]{6}") String number) {
        this.number = number;
    }
}
