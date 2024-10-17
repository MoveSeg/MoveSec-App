package com.moveseg.app.viagem.Programacao.domain.cmd;

import java.time.LocalDateTime;

import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarProgramacao {
    public LocalDateTime data;
    public ViagemId viagem;
}
