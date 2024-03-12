package com.moveseg.app.viagem.Rota.domain.cmd;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.RotaId;

import lombok.Data;

@Data
public class CriarRota {
    public VeiculoId veiculo;
    public RotaId id;
    public Numero numero;
    public List<Endereco> enderecos;
}