package com.moveseg.app.checklist.Checklist.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NomeTest {
    @Test
    void dadoUmNomeValidoDeveCriar() throws Exception {
        Nome nome = Nome.of("Onibus");
        assertNotNull(nome);
        assertEquals("Onibus", nome.nome());
    }

    @Test
    void dadoUmNomeInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Nome.of(null));
    }

    @Test
    void dadoUmNomeVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Nome.of(""));
    }
}
