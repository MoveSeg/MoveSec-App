package com.moveseg.app.cadastro.Aluno.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarteirinhaTest {
     @Test
    void dadoUmaCarteirinhaValidaDeveCriar() throws Exception{
        Carteirinha carteirinha = Carteirinha.of((1111111111));
        assertNotNull(carteirinha);
        assertEquals((1111111111), carteirinha.value());
    }

    @Test 
    void dadoUmaCarteirinhaInvalidaNaoDeveCriar(){
        assertThrows(Exception.class, () -> Carteirinha.of(null));
    }
    @Test 
    void dadoUmaCarteirinhaVaziaNaoDeveCriar(){
        assertThrows(Exception.class, () -> Carteirinha.of(0));
    }
    
}
