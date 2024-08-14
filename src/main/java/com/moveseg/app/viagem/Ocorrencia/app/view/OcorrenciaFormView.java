package com.moveseg.app.viagem.Ocorrencia.app.view;


import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaFormView {
    private OcorrenciaId id;
    private String motivo;
    private String data;
    private String aluno;
    private String viagem;

    public static OcorrenciaFormView of(Ocorrencia ocorrencia) {
        return OcorrenciaFormView.builder()
        .id(ocorrencia.id())
        .motivo(ocorrencia.motivo())
        .data(ocorrencia.data().toString())
        .aluno(ocorrencia.aluno().nome())
        .viagem(ocorrencia.viagem().data().toString())
        .build();
    }

    
}
