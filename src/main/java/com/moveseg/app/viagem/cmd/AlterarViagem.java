package com.moveseg.app.viagem.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.viagem.domain.MotoristaId;
import com.moveseg.app.viagem.domain.RotaId;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarViagem {
    private ViagemId id;
    private Aluno alunos;
    private RotaId rota;
    private MotoristaId motorista;
    private LocalDate data;
    public Viagem build() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'build'");
    }
}
