package com.moveseg.app.cadastro.Instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.instituto.domain.Email;

public class EmailTest {
    @Test
    void dadoUmEnderecoValidoDeveCriar() throws Exception {
        Email email = Email.of("ExemploEmail@gmail.com");
        assertNotNull(email);
        assertEquals("ExemploEmail@gmail.com", email.email());
    }

    @Test
    void dadoUmEnderecoInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Email.of(null));
    }

    @Test
    void dadoUmEnderecoVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Email.of(""));
    }

}
