package com.moveseg.app.viagem.Rota.domain.cmd;

import java.util.List;

import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.EnderecoId;

import com.moveseg.app.viagem.Rota.domain.RotaId;

import lombok.Data;

@Data
public class AtualizarRota {
    public VeiculoId veiculo;
    public RotaId id;
    public Integer numeroRota;
    public List<EnderecoId> enderecos;
}
