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
    private String logradouros;
    private Number numeros;
    private String numeroRota;
    private VeiculoId veiculo;

    public static RotaListView of(Rota rota) {
        return RotaListView.builder()
                .id(rota.id())
                .logradouros(rota.enderecos().get(0).logradouro())
                .numeros(rota.enderecos().get(0).numero())
                .numeroRota(rota.numero().toString())
                .veiculo(rota.veiculo())
                .build();
    }
}
