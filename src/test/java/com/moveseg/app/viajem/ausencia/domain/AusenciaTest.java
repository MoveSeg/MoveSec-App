package com.moveseg.app.viajem.ausencia.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public final class AusenciaTest {
    
    @Test
    void ausenciaCompletoDeveSalvar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        Ausencia ausencia = Ausencia.from(viagem, "Doente");
        assertNotNull(ausencia);
        assertNotNull(ausencia.id());
        assertNotNull(ausencia.data());
        assertNotNull(ausencia.viagem());
        assertEquals("Doente", ausencia.motivo());
    }

    @Test
    void dadoUmaAusenciaSemMotivoNaoDeveCriar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        assertThrows(Exception.class, () -> {
            Ausencia.from(viagem, null);
        });
    }

    @Test
    void dadoUmaAusenciaSemViagemNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, "Motivo");
        });
    }

    @Test
    void dadoUmaAusenciaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, null);
        });
    }
}