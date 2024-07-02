package com.moveseg.app.checklist.Item.domain.cmd;

import com.moveseg.app.checklist.Item.domain.Descricao;
import com.moveseg.app.checklist.Item.domain.Observacao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarItem {
    private Descricao descricao;
    private Boolean resposta;
    private Observacao observacao;
}
