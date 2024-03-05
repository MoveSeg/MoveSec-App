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
import com.moveseg.app.viagem.ausencias.domain.Ausencia.AusenciaBuilder;

public final class AusenciaTest {

    private String motivo;

    private LocalDate data;
    private AusenciaBuilder builder;

    @BeforeEach
    void initializeBuilder() throws Exception {

        motivo = ("Doença");
        data = LocalDate.of(2000, 1, 20);
        this.builder = Ausencia.builder()
                .motivo(motivo)
                .data(data);
    }

    @Test
    void ausenciaCompletoDeveSalvar() {
        Ausencia ausencia = this.builder.build();
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

    @Test
    void dadoUmaAusenciaSemHoraNaoDeveCriar() {
        this.builder.data(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }
}
