package com.moveseg.app.cadastro.veiculo.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RenavamValidator implements ConstraintValidator<RenavamAnnotation, String> {

    public boolean isValid(String renavam, ConstraintValidatorContext context) {
        String renavamAlfanumerica = renavam.replaceAll("[^a-zA-Z0-9]", "");
        
        return renavamAlfanumerica.matches("[0-9]{11}");
    }
}
