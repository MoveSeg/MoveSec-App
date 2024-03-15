package com.moveseg.app.viagem.rota.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.Rota.domain.Numero;

class NumeroTest {

    @Test
    void dadoUmNumeroValidoDeveCriar() throws Exception {
        Numero numero = Numero.of("317R");
        assertNotNull(numero);
        assertEquals("317R", numero.value());
    }

    @Test
    void dadoUmNumeroInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Numero.of(null));
    }

    @Test
    void dadoUmNumeroVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Numero.of(""));
    }
}