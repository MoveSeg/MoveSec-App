package com.moveseg.app.viagem.Programacao.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.viagem.domain.ViagemId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarProgramacao {
    public LocalDate data;
    public ViagemId viagem;
}
