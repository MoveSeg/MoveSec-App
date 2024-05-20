package com.moveseg.app.viagem.Rota.app.view;

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
    private String logradouro;
    private Integer numero;
    private Integer numeroRota;
    private VeiculoId veiculo;

    public static RotaListView of(Rota rota) {
        return RotaListView.builder()
                .id(rota.id())
                .logradouro(rota.enderecos().logradouro())
                .numero(rota.enderecos().numero())
                .numeroRota(rota.numeroRota())
                .veiculo(rota.veiculo())
                .build();
    }
}
