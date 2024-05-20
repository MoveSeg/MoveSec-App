package com.moveseg.app.cadastro.veiculo.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidator implements ConstraintValidator<PlacaAnnotation, String> {

    @Override
    public boolean isValid(String numero, ConstraintValidatorContext context) {
        String numeroAlfanumerico = numero.replaceAll("[^a-zA-Z0-9]", "");

        return !numeroAlfanumerico.isEmpty();
    }
}