package com.moveseg.app.cadastro.responsavel.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnderecoValidator implements ConstraintValidator<EnderecoAnnotation, String> {

    @Override
    public boolean isValid(String endereco, ConstraintValidatorContext context) {
        String enderecoAlfanumerico = endereco.replaceAll("[^a-zA-Z0-9]", "");

        return enderecoAlfanumerico.matches("[a-zA-Z0-9]+");
    }
}
