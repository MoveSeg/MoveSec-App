package com.moveseg.app.cadastro.veiculo.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidator implements ConstraintValidator<PlacaAnnotation, String> {

    @Override
    public boolean isValid(String placa, ConstraintValidatorContext context) {
        String placaAlfanumerica = placa.replaceAll("[^a-zA-Z0-9]", "");

        return placaAlfanumerica.matches("[A-Za-z]{3}[0-9]{1}[A-Za-z]{1}[0-9]{2}");
    }
}