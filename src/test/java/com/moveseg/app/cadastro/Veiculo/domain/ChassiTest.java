package com.moveseg.app.cadastro.veiculo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ChassiTest {

    @Test
    void dadoUmChassiValidoDeveCriar() {
        Chassi chassi = Chassi.of("fgfg");
        assertNotNull(chassi);
        assertEquals("fgfg", chassi.value());
    }

    @Test
    void dadoUmChassiInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Chassi.of(null));
    }

    @Test
    void dadoUmChassiVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Chassi.of(""));
    }
}
