package com.moveseg.app.cadastro.Veiculo.domain.cmd;

import com.moveseg.app.cadastro.Veiculo.domain.Chassi;
import com.moveseg.app.cadastro.Veiculo.domain.Placa;
import com.moveseg.app.cadastro.Veiculo.domain.Renavam;

public class AtualizarVeiculo {

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
