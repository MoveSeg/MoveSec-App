package com.moveseg.app.viagem.Ocorrencia.domain.cmd;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.Ocorrencia.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarOcorrencia {
    public String motivo;
    public ViagemId viagem;
    public AlunoId aluno;


}
