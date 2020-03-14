package co.edu.javeriana.ddd.spring.dddspringdemo.sales.customer.domain;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCustomer {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
