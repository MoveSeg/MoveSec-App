package com.moveseg.app.viagem.ausencias.domain.cmd;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarAusencia {
    private String motivo;
    private LocalDate data;
}
