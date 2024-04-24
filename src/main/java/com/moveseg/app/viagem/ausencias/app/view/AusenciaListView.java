package com.moveseg.app.viagem.ausencias.app.view;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.AusenciaId;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AusenciaListView {
    private AusenciaId id;
    private AlunoId aluno;
    private String motivo;
    private ViagemId Viagem;

    public static AusenciaListView of(Ausencia ausencia) {
        return AusenciaListView.builder()
                .id(ausencia.id())
                .motivo(ausencia.motivo())
                .aluno(ausencia.aluno())
                .Viagem(ausencia.viagem())
                .build();
    }
}
