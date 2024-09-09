package com.moveseg.app.checklist.Checklist.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Item.app.view.ItemListView;

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
    private List<ItemListView> itens;

    public static ChecklistListView of(Checklist checklist) {
        return ChecklistListView.builder()
                .id(checklist.id())
                .nome(checklist.nome().nome())
                .itens(checklist.itens().stream()
                        .map(ItemListView::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
