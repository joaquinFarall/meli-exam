package org.example.meliexam.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DnaValidator implements ConstraintValidator<DnaValid, String[]> {

    @Override
    public void initialize(DnaValid constraintAnnotation) {}

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        if (dna == null || dna.length == 0) return false;

        for (String sequence : dna) {
            if (sequence.length() != dna.length || !sequence.matches("[ACGT]+")) {
                return false;
            }
        }
        return true;
    }
}
