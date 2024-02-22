package com.moveseg.app.cadastro.instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.instituto.domain.Telefone;

public class TelefoneTest {
    
    @Test
    void dadoUmNumeroValidoDeveCriar() throws Exception{
        Telefone telefone = Telefone.of(("415555555"));
        assertNotNull(telefone);
        assertEquals(("415555555"), telefone.numero());
    }

    @Test 
    void dadoUmEnderecoInvalidoNaoDeveCriar(){
        assertThrows(Exception.class, () -> Telefone.of(null));
    }
    @Test 
    void dadoUmEnderecoVazioNaoDeveCriar(){
        assertThrows(Exception.class, () -> Telefone.of(("0")));
    }

}
