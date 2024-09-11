package com.moveseg.app.viagem.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.viagem.Rota.domain.Rota;
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
public class ViagemFormView {
    private ViagemId id;
    private Rota rota;
    private Motorista motorista;
    private List<String> alunos;
    private Veiculo veiculo;
    private String data;

    public static ViagemFormView of(Viagem viagem) {
        return ViagemFormView.builder()
                .rota(viagem.rota())
                .motorista(viagem.motorista())
                .alunos(viagem.alunos().stream().map(Aluno::nome).collect(Collectors.toList()))
                .veiculo(viagem.veiculo())
                .data(viagem.data().toString())
                .build();
    }

}