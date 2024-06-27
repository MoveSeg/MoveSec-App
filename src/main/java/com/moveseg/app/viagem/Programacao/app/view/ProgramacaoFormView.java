package com.moveseg.app.viagem.Programacao.app.view;

import java.time.LocalDate;

import com.moveseg.app.checklist.Checklist.app.view.ChecklistListView;
import com.moveseg.app.checklist.Checklist.domain.Checklist;
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
public class ProgramacaoFormView {
    public ProgramacaoId id;
    public String viagem;
    public LocalDate data;

    public static ProgramacaoFormView of(Programacao programacao) {
        return ProgramacaoFormView.builder()
                .id(programacao.id())
                .viagem(programacao.viagem().id().toUUID())
                .data(programacao.data())
                .build();
    }
}
