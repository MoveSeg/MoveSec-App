package com.moveseg.app.cadastro.veiculo.domain.cmd;

import com.moveseg.app.cadastro.veiculo.domain.Chassi;
import com.moveseg.app.cadastro.veiculo.domain.Placa;
import com.moveseg.app.cadastro.veiculo.domain.Renavam;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CriarVeiculo {

    private Placa placa;
    private Integer numeroDaFrota;
    private Chassi chassi;
    private Renavam renavam;
    private Integer anoModelo;
    private String marca;
    private String modelo;
    private String corPredominante;
    private Integer capacidadeDePassageiros;

}
