package com.moveseg.app.checklist.Checklist.app.view;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistListView {
    private ChecklistId id;
    private String nome;
    private String itens;
    
    public static ChecklistListView of(Checklist checklist) {
        return ChecklistListView.builder()
                .id(checklist.id())
                .nome(checklist.nome().nome())
                .itens(checklist.itens().get(0).descricao().descricao())
                .build();
    }
}
