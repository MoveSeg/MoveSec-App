package com.moveseg.app.viagem.Ocorrencia.app.view;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaListView {
    private OcorrenciaId id;
    private String motivo;
    private String data;
    private AlunoId aluno;
    private ViagemId viagem;

    public static OcorrenciaListView of(Ocorrencia ocorrencia) {
        return OcorrenciaListView.builder()
        .id(ocorrencia.id())
        .motivo(ocorrencia.motivo())
        .data(ocorrencia.data().toString())
        .aluno(ocorrencia.aluno())
        .viagem(ocorrencia.viagem())
        .build();
    }

    
}
