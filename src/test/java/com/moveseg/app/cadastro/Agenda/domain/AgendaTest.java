package com.moveseg.app.cadastro.Agenda.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class AgendaTest {

    private ViagemId viagem;
    private LocalDate data;

    @Test
    void agendaCompletoDeveSalvar() {
        viagem = DomainObjectId.randomId(ViagemId.class);
        data = LocalDate.of(2000, 1, 20);
        Agenda agenda = Agenda.from(viagem, data);
        assertNotNull(agenda);
        assertNotNull(agenda.id());
        assertNotNull(data);
        assertNotNull(viagem);
    }

    @Test
    void dadoUmaAgendaSemDataNaoDeveCriar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        assertThrows(Exception.class, () -> {
            Agenda.from(viagem, null);
        });
    }

    @Test
    void dadoUmaAgendaSemViagemNaoDeveCriar() {
        data = LocalDate.of(2014, 07, 10);
        assertThrows(Exception.class, () -> {
            Agenda.from(null, data);
        });
    }

    @Test
    void dadoUmaAgendaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Agenda.from(null, null);
        });
    }
}
