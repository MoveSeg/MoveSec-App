package com.moveseg.app.checklist.GrupoChecklist.app.list;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;
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
    private List<Nome> checklists;
    
    public static GrupoChecklistListView of(GrupoChecklist grupoChecklist) {
        return GrupoChecklistListView.builder()
                .id(grupoChecklist.id())
                .nome(grupoChecklist.nome().nome())
                .checklists(grupoChecklist.checklists().stream().map(Checklist::nome).collect(Collectors.toList()))
                .build();
    }
}
