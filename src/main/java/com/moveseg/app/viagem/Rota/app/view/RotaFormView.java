package com.moveseg.app.viagem.Rota.app.view;

import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RotaFormView {
    private RotaId id;
    private String logradouros;
    private Number numeros;
    private String numeroRota;
    private VeiculoId veiculo;

    public static RotaFormView of(Rota rota) {
        return RotaFormView.builder()
                .id(rota.id())
                .logradouros(rota.enderecos().get(0).logradouro())
                .numeros(rota.enderecos().get(0).numero())
                .numeroRota(rota.numero().toString())
                .veiculo(rota.veiculo())
                .build();
    }
}
