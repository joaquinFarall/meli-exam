package org.example.meliexam.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DnaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DnaValid {
    String message() default "The adn sequence array can only contain strings with the characters A, C, G, T and the length of the strings needs to be the same as the array";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}