package com.moveseg.app.checklist.GrupoChecklist.app.list;

import java.util.List;
import java.util.stream.Collectors;

<<<<<<< Updated upstream
import com.moveseg.app.checklist.Checklist.app.view.ChecklistListView;
=======
import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    private List<ChecklistListView> checklists;
=======
    private List<Nome> checklists;
>>>>>>> Stashed changes
    
    public static GrupoChecklistFormView of(GrupoChecklist grupoChecklist) {
        return GrupoChecklistFormView.builder()
                .id(grupoChecklist.id())
                .nome(grupoChecklist.nome().nome())
<<<<<<< Updated upstream
                .checklists(grupoChecklist.checklists().stream()
                        .map(ChecklistListView::of)
                        .collect(Collectors.toList()))
=======
                .checklists(grupoChecklist.checklists().stream().map(Checklist::nome).collect(Collectors.toList()))
>>>>>>> Stashed changes
                .build();
    }
}
