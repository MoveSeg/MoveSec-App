package com.moveseg.app.checklist.Item.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ObservacaoTest {
    @Test
    void dadoUmaObservacaoValidaDeveCriar() throws Exception {
        Observacao observacao = Observacao.of("Observe...");
        assertNotNull(observacao);
        assertEquals("Observe...", observacao.observacao());
    }

    @Test
    void dadoUmObservacaoInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Observacao.of(null));
    }

    @Test
    void dadoUmObservacaoVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Observacao.of(""));
    }
}
