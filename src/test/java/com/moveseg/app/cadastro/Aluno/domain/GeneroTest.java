package com.moveseg.app.cadastro.Aluno.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GeneroTest {
     @Test
    void dadoUmGeneroValidoDeveCriar() throws Exception{
        Genero genero = Genero.of("Genero");
        assertNotNull(genero);
        assertEquals("Genero" , genero.genero());
    }

    @Test 
    void dadoUmGeneroInvalidoNaoDeveCriar(){
        assertThrows(Exception.class, () -> Genero.of(null));
    }
    @Test 
    void dadoUmGeneroVazioNaoDeveCriar(){
        assertThrows(Exception.class, () -> Genero.of(""));
    }
    
}
