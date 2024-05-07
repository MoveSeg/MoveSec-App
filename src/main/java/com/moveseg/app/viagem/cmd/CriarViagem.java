package com.moveseg.app.viagem.cmd;

import java.time.LocalDate;
import java.util.List;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.domain.MotoristaId;
import com.moveseg.app.viagem.domain.RotaId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarViagem {
    private List<AlunoId> alunos;
    private RotaId rota;
    private MotoristaId motorista;
    private LocalDate data;
}
