package com.moveseg.app.viagem.Ocorrencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.ViagemId;

public class OcorrenciaTest {

    private String motivo = "Dormiu demais";
    private LocalDate data = LocalDate.of(2024, 02, 02);

    @Test
    void dadoUmaOcorrenciaCompletaDeveCriar() throws Exception {
        Ocorrencia ocorrencia = Ocorrencia.of("Dormi demais");
        assertNotNull(ocorrencia);
        assertNotNull(ocorrencia.id());
        assertEquals(motivo, ocorrencia.motivo());
        assertEquals(data, ocorrencia.data());
    }

    @Test
    void dadoUmaOcorrenciaSemDataNaoDeveCriar() {
        Ocorrencia ocorrencia = Data.of(null);
        assertThrows(Exception.class, () -> ());
    }

    @Test
    void dadoUmaOcorrenciaSemMotivoNaoDeveCriar() {
        Ocorrencia ocorrencia = Motivo.of(null);
        assertThrows(Exception.class, () -> ());
    }

}
