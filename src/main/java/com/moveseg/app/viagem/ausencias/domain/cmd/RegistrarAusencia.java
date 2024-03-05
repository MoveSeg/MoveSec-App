package com.moveseg.app.viagem.ausencias.domain.cmd;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.ausencias.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarAusencia {
    private String motivo;
    private ViagemId viagem;
    private AlunoId aluno;
    
}
