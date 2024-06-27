package com.moveseg.app.viagem.Programacao.app.view;

import java.time.LocalDate;

import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacaoListView {
    public ProgramacaoId id;
    public String viagem;
    public LocalDate data;

    public static ProgramacaoListView of(Programacao programacao) {
        return ProgramacaoListView.builder()
                .id(programacao.id())
                .viagem(programacao.viagem().id().toUUID())
                .data(programacao.data())
                .build();
    }
}
