package com.moveseg.app.cadastro.Agenda.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class AgendaTest {
    @Test
    void agendaCompletoDeveSalvar() {
        ViagemId viagem = DomainObjectId.randomId(ViagemId.class);
        LocalDate data = LocalDate.of(2014, 07, 10);
        Agenda agenda = Agenda.from(viagem, data);
        assertNotNull(agenda);
        assertNotNull(agenda.id());
        assertNotNull(agenda.data());
        assertNotNull(agenda.viagem());
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
        LocalDate data = LocalDate.of(2014, 07, 10);
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

    @Test
    void dadoUmaAgendaCompletaDeveAtualizar() throws Exception {

        assertThrows(Exception.class, () -> {
            LocalDate novaData = LocalDate.of(2014, 07, 10);
            ViagemId novaViagem = DomainObjectId.randomId(ViagemId.class);
            Agenda.atualizar()
                    .data(novaData)
                    .viagem(novaViagem).aplicar();
        });
    }

    @Test
    void dadoUmaDataNulaNaoDeveAtualizar() {

        assertThrows(Exception.class, () -> {
            LocalDate novaData = LocalDate.of(2014, 07, 10);
            ViagemId novaViagem = DomainObjectId.randomId(ViagemId.class);
            Agenda.atualizar()
            .viagem(novaViagem).aplicar();
        });
    }

    @Test
    void dadoResponsavelNuloDeveCriarVazio() {
        assertThrows(Exception.class, () -> {
            LocalDate novaData = LocalDate.of(2014, 07, 10);
            ViagemId novaViagem = DomainObjectId.randomId(ViagemId.class);
            Agenda.atualizar()
            .data(novaData).aplicar();
        });
    }
}
