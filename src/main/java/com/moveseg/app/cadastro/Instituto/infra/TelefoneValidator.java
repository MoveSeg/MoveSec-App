package com.moveseg.app.cadastro.Instituto.infra;

import com.moveseg.app.cadastro.Instituto.domain.Telefone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Phone, Telefone> {
    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    public boolean isValid(Telefone telefone, ConstraintValidatorContext context) {
        String telefoneString = telefone.numero().toString();
        if (telefone != null) {
            return telefoneString.matches("\\d{8,15}");
        }
        return false;
    }
}
