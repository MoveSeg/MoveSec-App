package com.moveseg.app.cadastro.Instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;

public class ResponsaveTest {
    @Test
    void dadoUmEnderecoValidoDeveCriar() throws Exception{
        Responsavel responsavel = Responsavel.of("Nome Responsavel");
        assertNotNull(responsavel);
        assertEquals("Nome Responsavel", responsavel.nome());
    }

    @Test 
    void dadoUmEnderecoInvalidoNaoDeveCriar(){
        assertThrows(Exception.class, () -> Responsavel.of(null));
    }
    @Test 
    void dadoUmEnderecoVazioNaoDeveCriar(){
        assertThrows(Exception.class, () -> Responsavel.of(""));
    }
}
