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

    public static RotaFormView of(Rota rota) {
        return RotaFormView.builder()
                .id(rota.id())
                .logradouro(rota.enderecos().get(0).logradouro())
                .numero(rota.enderecos().get(0).numero())
                .numeroRota(rota.numeroRota().value())
                .build();
    }
}
