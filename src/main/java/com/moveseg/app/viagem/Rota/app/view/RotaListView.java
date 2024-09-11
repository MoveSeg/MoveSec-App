package com.moveseg.app.viagem.Rota.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RotaListView {
    private RotaId id;
    private List<String> logradouro;
    private List<Integer> numero;
    private String numeroRota;
    private VeiculoId veiculo;

    public static RotaListView of(Rota rota) {
        return RotaListView.builder()
                .id(rota.id())
                .logradouro(rota.enderecos().stream().map(Endereco::logradouro).collect(Collectors.toList()))
                .numero(rota.enderecos().stream().map(Endereco::numero).collect(Collectors.toList()))
                .numeroRota(rota.numeroRota().value())
                .build();
    }
}
