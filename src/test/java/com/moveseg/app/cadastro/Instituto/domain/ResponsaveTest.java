package com.moveseg.app.cadastro.instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.instituto.domain.Responsavel;

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
