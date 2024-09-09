package com.moveseg.app.checklist.Resposta.app.view;

import java.time.LocalDate;

import com.moveseg.app.checklist.Resposta.domain.Resposta;
import com.moveseg.app.checklist.Resposta.domain.RespostaId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostaListView {
    private RespostaId id;
    private String grupoChecklist;
    private String checklist;
    private String item;
    private Long IdUsuario;
    private Boolean resposta;
    private LocalDate data;

    public static RespostaListView of(Resposta resposta) {
        return RespostaListView.builder()
                .id(resposta.id())
                .grupoChecklist(resposta.grupoChecklist().nome().nome())
                .checklist(resposta.checklist().nome().nome())
                .item(resposta.item().descricao().descricao())
                .IdUsuario(resposta.IdUsuario())
                .resposta(resposta.resposta())
                .data(resposta.data())
                .build();
    }
}
