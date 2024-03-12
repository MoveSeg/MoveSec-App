package com.moveseg.app.viagem.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.viagem.domain.MotoristaId;
import com.moveseg.app.viagem.domain.RotaId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarViagem {
    private Aluno alunos;
    private RotaId rota;
    private MotoristaId motorista;
    private LocalDate data;
}
