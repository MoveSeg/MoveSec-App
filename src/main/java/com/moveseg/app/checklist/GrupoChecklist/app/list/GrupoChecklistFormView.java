package com.moveseg.app.checklist.GrupoChecklist.app.list;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.checklist.Checklist.app.view.ChecklistListView;
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
public class GrupoChecklistFormView {
private GrupoChecklistId id;
    private String nome;
    private List<ChecklistListView> checklists;
    
    public static GrupoChecklistFormView of(GrupoChecklist grupoChecklist) {
        return GrupoChecklistFormView.builder()
                .id(grupoChecklist.id())
                .nome(grupoChecklist.nome().nome())
                .checklists(grupoChecklist.checklists().stream()
                        .map(ChecklistListView::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
