package com.moveseg.app.viagem.domain.cmd;

import java.time.LocalDate;
import java.util.List;

import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarViagem {
    private ViagemId id;
    private List<String> alunos;
    private RotaId rota;
    private MotoristaId motorista;
    private VeiculoId veiculo;
    private LocalDate data;
}
