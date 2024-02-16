package com.moveseg.app.cadastro.dominio.veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.domain.Placa;

class PlacaTest {

    @Test
    void dadoUmaPlacaValidaDeveCriar() {
        Placa placa = Placa.of("asd");
        assertNotNull(placa);
        assertEquals("asd", placa.value());
    }

    @Test
    void dadoUmaPlacaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> Placa.of(null));
    }

    @Test
    void dadoUmaPlacaVaziaNaoDeveCriar() {
        assertThrows(Exception.class, () -> Placa.of(""));
    }
}
