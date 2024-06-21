package com.moveseg.app.viagem.Rota.domain.cmd;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.RotaId;

import lombok.Data;

@Data
public class AtualizarRota {
    public RotaId id;
    public Numero numeroRota;
    public List<Endereco> enderecos;
}
