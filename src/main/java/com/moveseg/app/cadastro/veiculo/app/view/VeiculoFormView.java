package com.moveseg.app.cadastro.veiculo.app.view;

import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VeiculoFormView {
    private VeiculoId id;
    private String placa;
    private Integer numeroDaFrota;
    private String chassi;
    private String renavam;
    private Integer anoModelo;
    private String marca;
    private String modelo;
    private String corPredominante;
    private Integer capacidadeDePassageiros;

    public static VeiculoFormView of(Veiculo veiculo) {
        return VeiculoFormView.builder()
                .id(veiculo.id())
                .placa(veiculo.placa().placa())
                .numeroDaFrota(veiculo.numeroDaFrota())
                .chassi(veiculo.chassi().chassi())
                .renavam(veiculo.renavam().renavam())
                .anoModelo(veiculo.anoModelo())
                .marca(veiculo.marca())
                .modelo(veiculo.modelo())
                .corPredominante(veiculo.corPredominante())
                .capacidadeDePassageiros(veiculo.capacidadeDePassageiros())
                .build();
    }

}