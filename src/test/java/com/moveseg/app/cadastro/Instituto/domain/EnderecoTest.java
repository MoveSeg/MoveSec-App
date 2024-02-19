package com.moveseg.app.cadastro.instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.instituto.domain.Endereco;

public class EnderecoTest {

    @Test
    void dadoUmEnderecoValidoDeveCriar() throws Exception{
        Endereco endereco = Endereco.of("ndsdufn", 888);
        assertNotNull(endereco);
        assertEquals(endereco, endereco);
    }

    @Test 
    void dadoUmEnderecoInvalidoNaoDeveCriar(){
        assertThrows(Exception.class, () -> Endereco.of(null, null));
    }
    @Test 
    void dadoUmEnderecoVazioNaoDeveCriar(){
        assertThrows(Exception.class, () -> Endereco.of("", 0));
    }
    
}
