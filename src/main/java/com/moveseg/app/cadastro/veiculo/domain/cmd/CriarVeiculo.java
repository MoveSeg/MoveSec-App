package com.moveseg.app.cadastro.veiculo.domain.cmd;

import com.moveseg.app.cadastro.veiculo.domain.Chassi;
import com.moveseg.app.cadastro.veiculo.domain.Placa;
import com.moveseg.app.cadastro.veiculo.domain.Renavam;

import lombok.Builder;

@Builder
public class CriarVeiculo {

    public Placa placa;
    public Integer numeroDaFrota;
    public Chassi chassi;
    public Renavam renavam;
    public Integer anoModelo;
    public String marca;
    public String modelo;
    public String corPredominante;
    public Integer capacidadeDePassageiros;

}
