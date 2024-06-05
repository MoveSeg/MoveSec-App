package com.moveseg.app.viagem.ausencia.app.view;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.ausencia.domain.Ausencia;
import com.moveseg.app.viagem.ausencia.domain.AusenciaId;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AusenciaFormView {
    private AusenciaId id;
    private AlunoId aluno;
    private String data;
    private String motivo;
    private ViagemId viagem;

    public static AusenciaFormView of(Ausencia ausencia) {
        return AusenciaFormView.builder()
                .id(ausencia.id())
                .motivo(ausencia.motivo())
                .data(ausencia.data().toString())
                .aluno(ausencia.aluno())
                .viagem(ausencia.viagem())
                .build();
    }
}
