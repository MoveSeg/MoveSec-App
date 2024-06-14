package com.moveseg.app.viagem.ausencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public final class AusenciaTest {
    
    @Test
    void ausenciaCompletoDeveSalvar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        Ausencia ausencia = Ausencia.from(viagem, "Doente", aluno);
        assertNotNull(ausencia);
        assertNotNull(ausencia.id());
        assertNotNull(ausencia.data());
        assertNotNull(ausencia.viagem());
        assertEquals("Doente", ausencia.motivo());
    }

    @Test
    void dadoUmaAusenciaSemMotivoNaoDeveCriar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        assertThrows(Exception.class, () -> {
            Ausencia.from(viagem, null, aluno);
        });
    }

    @Test
    void dadoUmaAusenciaSemViagemNaoDeveCriar() {
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, "Motivo", aluno);
        });
    }
    @Test
    void dadoUmaAusenciaSemAlunoNaoDeveCriar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        assertThrows(Exception.class, () -> {
            Ausencia.from(viagem, null, null);
        });
    }

    @Test
    void dadoUmaAusenciaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, null, null);
        });
    }
}