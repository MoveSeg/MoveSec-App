package com.moveseg.app.viagem.ocorrencia.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.ViagemId;

public class OcorrenciaTest {

    private String motivo = "Dormiu demais";

    @Test
    void dadoUmaOcorrenciaCompletaDeveCriar() throws Exception {
        ViagemId id = randomId(ViagemId.class);
        Ocorrencia ocorrencia = Ocorrencia.of(motivo, id);
        
        assertNotNull(ocorrencia);
        assertNotNull(ocorrencia.id());
        assertEquals(motivo, ocorrencia.motivo());
        assertEquals(id, ocorrencia.viagem());
    }

    @Test
    void dadoUmaOcorrenciaSemViagemNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of("Dormi demais", null);
        });
    }

    @Test
    void dadoUmaOcorrenciaSemMotivoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, randomId(ViagemId.class));
        });
    }


    @Test
    void dadoUmaOcorrenciaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, null);
        });
    }
}
