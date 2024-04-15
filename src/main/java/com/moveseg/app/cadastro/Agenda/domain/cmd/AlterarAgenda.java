package com.moveseg.app.cadastro.Agenda.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Agenda.domain.AgendaId;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarAgenda {
    public AgendaId id;
    private LocalDate data;
    private ViagemId viagem;
}
