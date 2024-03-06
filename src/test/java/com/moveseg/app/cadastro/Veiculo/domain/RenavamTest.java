package com.moveseg.app.cadastro.veiculo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Veiculo.domain.Renavam;

public class RenavamTest {
    @Test
    void dadoUmRenavamValidoDeveCriar() {
        Renavam renavam = Renavam.of("afaf");
        assertNotNull(renavam);
        assertEquals("afaf", renavam.value());
    }

    @Test
    void dadoUmRenavamInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Renavam.of(null));
    }

    @Test
    void dadoUmRenavamaVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Renavam.of(""));
    }
}
