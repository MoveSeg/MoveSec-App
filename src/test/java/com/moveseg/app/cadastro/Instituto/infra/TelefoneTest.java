package com.moveseg.app.cadastro.instituto.infra;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.moveseg.app.cadastro.instituto.domain.Telefone;
import com.moveseg.app.cadastro.instituto.infra.TelefoneValidator;

import jakarta.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;

public class TelefoneTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;
    @Mock
    TelefoneValidator telefoneValidator;

    private TelefoneValidator validator = new TelefoneValidator();

    @Test
    public void testTelefoneValido() throws Exception {
        String  numero ="333333333";
        Telefone telefone = Telefone.of(numero);
        assertTrue(validator.isValid(telefone, constraintValidatorContext));
    }

    @Test
    public void testTelefoneInvalido() throws Exception {
        Telefone telefone = Telefone.of("123");
        assertFalse(validator.isValid(telefone, constraintValidatorContext));
    }
}