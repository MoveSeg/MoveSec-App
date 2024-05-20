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
    private String logradouro;
    private Integer numero;
    private String numeroRota;
    private VeiculoId veiculo;

    public static RotaFormView of(Rota rota) {
        return RotaFormView.builder()
                .id(rota.id())
                .logradouro(rota.endereco().logradouro())
                .numero(rota.endereco().numero())
                .numeroRota(rota.numeroRota())
                .veiculo(rota.veiculo())
                .build();
    }
}
