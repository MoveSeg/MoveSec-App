package com.moveseg.app.viagem.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumeroValidator implements ConstraintValidator<NumeroAnnotation, String> {

    @Override
    public boolean isValid(String numero, ConstraintValidatorContext context) {
        String numeroAlfanumerico = numero.replaceAll("[^a-zA-Z0-9]", "");

        return !numeroAlfanumerico.isEmpty();
    }
}
