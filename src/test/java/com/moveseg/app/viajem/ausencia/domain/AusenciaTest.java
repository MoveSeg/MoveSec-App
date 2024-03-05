package com.moveseg.app.viajem.ausencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.viagem.ausencias.domain.Ausencia;

public final class AusenciaTest {

    private String motivo;

    private LocalDate data;
    private Ausencia builder;

    @Test
    void ausenciaCompletoDeveSalvar() {
        motivo = ("Estou doente");
        data = LocalDate.now();
        Ausencia ausencia;
        assertNotNull(ausencia);
        assertNotNull(ausencia.id());
        assertEquals(this.motivo, ausencia.motivo());
        assertEquals(this.data, ausencia.data());
    }

     @Test
    void dadoUmaAusenciaSemMotivoNaoDeveCriar() {
        this.builder.motivo(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }
}
