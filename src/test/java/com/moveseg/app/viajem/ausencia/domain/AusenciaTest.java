package com.moveseg.app.viajem.ausencia.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.ViagemId;

public final class AusenciaTest {

    ViagemId viagem;
    
    @Test
    void ausenciaCompletoDeveSalvar() {
        Ausencia ausencia = Ausencia.of("Estou malzão! Malz ae");
        assertNotNull(ausencia);
        assertNotNull(ausencia.id());
        assertNotNull(ausencia.data());
        assertNotNull(ausencia.viagem());
        assertEquals("Estou malzão! Malz ae", ausencia.motivo());
    }

    @Test
    void dadoUmaAusenciaSemMotivoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.of(null);
        });
    }


}