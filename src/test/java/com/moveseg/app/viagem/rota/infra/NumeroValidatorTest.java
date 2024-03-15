package com.moveseg.app.viagem.rota.infra;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.infra.NumeroValidator;

import jakarta.validation.ConstraintValidatorContext;

public class NumeroValidatorTest {

    private NumeroValidator validator = new NumeroValidator();
    private ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

    @Test
    void NumeroValido() {
        String numeroValido = "317R";
        assertTrue(validator.isValid(numeroValido, constraintValidatorContext));

    }

    @Test
    void NumeroInvalido() {
        String numeroInvalido = "";
        assertFalse(validator.isValid(numeroInvalido, constraintValidatorContext));
    }

}
