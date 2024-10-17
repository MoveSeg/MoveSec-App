package com.moveseg.app.viagem.Programacao.app.view;

import java.time.LocalDateTime;

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
    public LocalDateTime data;

    public static ProgramacaoFormView of(Programacao programacao) {
        return ProgramacaoFormView.builder()
                .id(programacao.id())
                .viagem(programacao.viagem().data().toString())
                .data(programacao.data())
                .build();
    }
}
