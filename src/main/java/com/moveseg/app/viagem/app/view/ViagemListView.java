package com.moveseg.app.viagem.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViagemListView {
    private ViagemId id;
    private RotaId rota;
    private MotoristaId motorista;
    private List<String> alunos;
    private VeiculoId veiculo;
    private String data;

    public static ViagemListView of(Viagem viagem) {
        return ViagemListView.builder()
                .id(viagem.id())
                .rota(viagem.rota())
                .motorista(viagem.motorista())
                .alunos(viagem.alunos().stream().map(Aluno::nome).collect(Collectors.toList()))
                .veiculo(viagem.veiculo())
                .data(viagem.data().toString())
                .build();
    }

}