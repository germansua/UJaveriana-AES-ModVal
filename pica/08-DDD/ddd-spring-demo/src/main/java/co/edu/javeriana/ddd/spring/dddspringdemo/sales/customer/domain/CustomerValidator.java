package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerValidator implements ConstraintValidator<ValidCustomer, Customer> {

    @Override
    public void initialize(ValidCustomer constraintAnnotation) {
    }

    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
        return !value.getFirstName().isBlank() && !value.getLastName().isBlank();
    }
}
