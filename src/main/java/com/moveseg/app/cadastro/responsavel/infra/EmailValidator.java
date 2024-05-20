package com.moveseg.app.cadastro.responsavel.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailAnnotation, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        String emailAlfanumerico = email.replaceAll(".*[a-zA-Z0-9]+.*@.*[a-zA-Z0-9]+.*", "");

        return emailAlfanumerico
                .matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    }
}