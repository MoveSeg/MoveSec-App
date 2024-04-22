package com.moveseg.app.viagem.ocorrencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class OcorrenciaTest {

    private String motivo = "Dormiu demais";

    @Test
    void dadoUmaOcorrenciaCompletaDeveCriar() throws Exception {
        ViagemId id = DomainObjectId.randomId(ViagemId.class);
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        Ocorrencia ocorrencia = Ocorrencia.of(motivo, id, aluno);

        assertNotNull(ocorrencia);
        assertNotNull(ocorrencia.id());
        assertNotNull(ocorrencia.viagem());
        assertNotNull(ocorrencia.aluno());
        assertEquals(motivo, ocorrencia.motivo());
    }

    @Test
    void dadoUmaOcorrenciaSemViagemNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
            Ocorrencia.of("Dormi demais", null, aluno);
        });
    }

    @Test
    void dadoUmaOcorrenciaSemMotivoNaoDeveCriar() {
        ViagemId id = DomainObjectId.randomId(ViagemId.class);
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, id, aluno);
        });
    }

    @Test
    void dadoUmaOcorrenciaSemAlunoNaoDeveCriar() {
        ViagemId id = DomainObjectId.randomId(ViagemId.class);
        assertThrows(Exception.class, () -> {
            Ocorrencia.of("Dormi demais", id, null );
        });
    }

    @Test
    void dadoUmaOcorrenciaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, null, null);
        });
    }
}
