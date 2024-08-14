package com.moveseg.app.viagem.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.veiculo.domain.Placa;
import com.moveseg.app.viagem.Rota.domain.Numero;
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
    private Numero rota;
    private String motorista;
    private List<String> alunos;
    private Placa veiculo;
    private String data;

    public static ViagemListView of(Viagem viagem) {
        return ViagemListView.builder()
                .id(viagem.id())
                .rota(viagem.rota().numeroRota())
                .motorista(viagem.motorista().nome())
                .alunos(viagem.alunos().stream().map(Aluno::nome).collect(Collectors.toList()))
                .veiculo(viagem.veiculo().placa())
                .data(viagem.data().toString())
                .build();
    }

}