package com.moveseg.app.cadastro.Agenda.domain;

import java.time.LocalDate;
import java.util.function.Consumer;

import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
 
@Getter
@RequiredArgsConstructor
public class AgendaForm {
    private final Consumer<AgendaForm> action;

    private LocalDate data;
    private ViagemId viagem;

    public AgendaForm data(LocalDate data) {
        this.data = data;
        return this;
    }

    public AgendaForm viagem(ViagemId viagem) {
        this.viagem = viagem;
        return this;
    }
    
    public void aplicar() {
        action.accept(this);
    }
}
