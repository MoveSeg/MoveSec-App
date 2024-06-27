package com.moveseg.app.cadastro.Aluno.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.sk.domain.Cpf;

public class CpfTest {
    
    @Test
    void dadoUmCpfValidoDeveCriar() throws Exception{
        Cpf cpf = Cpf.of(("1111111111"));
        assertNotNull(cpf);
        assertEquals(("1111111111"), cpf.cpf());
    }

    @Test 
    void dadoUmCpfInvalidoNaoDeveCriar(){
        assertThrows(Exception.class, () -> Cpf.of(null));
    }
    @Test 
    void dadoUmCpfVazioNaoDeveCriar(){
        assertThrows(Exception.class, () -> Cpf.of(""));
    }
    
}
