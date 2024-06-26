package com.moveseg.app.viagem.Programacao.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class ProgramacaoTest {

    private ViagemId viagem;
    private LocalDate data;

    @Test
    void agendaCompletoDeveSalvar() {
        viagem = DomainObjectId.randomId(ViagemId.class);
        data = LocalDate.of(2000, 1, 20);
        Programacao programacao = Programacao.from(viagem, data);
        assertNotNull(programacao);
        assertNotNull(programacao.id());
        assertNotNull(data);
        assertNotNull(viagem);
    }

    @Test
    void dadoUmaAgendaSemDataNaoDeveCriar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        assertThrows(Exception.class, () -> {
            Programacao.from(viagem, null);
        });
    }

    @Test
    void dadoUmaAgendaSemViagemNaoDeveCriar() {
        data = LocalDate.of(2014, 07, 10);
        assertThrows(Exception.class, () -> {
            Programacao.from(null, data);
        });
    }

    @Test
    void dadoUmaAgendaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Programacao.from(null, null);
        });
    }
}
