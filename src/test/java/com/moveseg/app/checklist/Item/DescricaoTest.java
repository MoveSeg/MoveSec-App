package com.moveseg.app.checklist.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.checklist.Item.domain.Descricao;

public class DescricaoTest {
    @Test
    void dadoUmaDescricaoValidaDeveCriar() throws Exception {
        Descricao descricao = Descricao.of("Tudo pronto?");
        assertNotNull(descricao);
        assertEquals("Tudo pronto?", descricao.descricao());
    }

    @Test
    void dadoUmDescricaoInvalidoNaoDeveCriar() {
        assertThrows(Exception.class, () -> Descricao.of(null));
    }

    @Test
    void dadoUmDescricaoVazioNaoDeveCriar() {
        assertThrows(Exception.class, () -> Descricao.of(""));
    }
}
