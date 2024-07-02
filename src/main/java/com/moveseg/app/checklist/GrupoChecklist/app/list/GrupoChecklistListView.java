package com.moveseg.app.checklist.GrupoChecklist.app.list;

import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrupoChecklistListView {
    private GrupoChecklistId id;
    private String nome;
    private String checklist;
    
    public static GrupoChecklistListView of(GrupoChecklist grupoChecklist) {
        return GrupoChecklistListView.builder()
                .id(grupoChecklist.id())
                .nome(grupoChecklist.nome().nome())
                .checklist(grupoChecklist.checklists().get(0).nome().nome())
                .build();
    }
}
