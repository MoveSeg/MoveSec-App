package com.moveseg.app.cadastro.cadastroInstituicao.infra;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.configuration.MockAnnotationProcessor;

import com.moveseg.app.cadastro.cadastroInstituicao.domain.Telefone;
import com.moveseg.app.cadastro.cadastroInstituicao.infra.TelefoneValidator;

import static org.mockito.Mockito.mock;

import jakarta.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;


public class TelefoneTest {
    @Mock
    ConstraintValidatorContext constraintValidatorContext;
    @Mock 
    TelefoneValidator telefoneValidator;

    private TelefoneValidator validator = new TelefoneValidator();

    @Test
    public void testTelefoneValido() {
        Integer numero = 333333333;
        Telefone telefone = Telefone.of(numero);
        assertTrue(validator.isValid(telefone, constraintValidatorContext));
       }

    @Test
    public void testTelefoneInvalido() {
        Telefone telefone = Telefone.of(123);
        assertFalse(validator.isValid(telefone, constraintValidatorContext));
    }
}