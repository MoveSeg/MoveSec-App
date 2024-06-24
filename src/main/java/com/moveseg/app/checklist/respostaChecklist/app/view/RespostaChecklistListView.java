package com.moveseg.app.checklist.respostaChecklist.app.view;

import java.time.LocalDate;

import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklist;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklistId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostaChecklistListView {
    private RespostaChecklistId id;
    private GrupoChecklistId grupoChecklist;
    private ChecklistId checklist;
    private ItemId item;
    private Long IdUsuario;
    private Boolean resposta;
    private LocalDate data; 

    public static RespostaChecklistListView of(RespostaChecklist respostaChecklist) {
        return RespostaChecklistListView.builder()
                .id(respostaChecklist.id())
                .grupoChecklist(respostaChecklist.grupoChecklist())
                .checklist(respostaChecklist.checklist())
                .item(respostaChecklist.item())
                .IdUsuario(respostaChecklist.IdUsuario())
                .resposta(respostaChecklist.resposta())
                .data(respostaChecklist.data())
                .build();
    }
}