package com.moveseg.app.checklist.Checklist.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
<<<<<<< Updated upstream
import com.moveseg.app.checklist.Item.app.view.ItemListView;
=======
import com.moveseg.app.checklist.Item.domain.Descricao;
import com.moveseg.app.checklist.Item.domain.Item;
>>>>>>> Stashed changes

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistFormView {
    private ChecklistId id;
    private String nome;
<<<<<<< Updated upstream
    private List<ItemListView> itens;
=======
    private List<Descricao> itens;
>>>>>>> Stashed changes
    
    public static ChecklistFormView of(Checklist checklist) {
        return ChecklistFormView.builder()
                .id(checklist.id())
                .nome(checklist.nome().nome())
<<<<<<< Updated upstream
                .itens(checklist.itens().stream()
                        .map(ItemListView::of)
                        .collect(Collectors.toList()))
=======
                .itens(checklist.itens().stream().map(Item::descricao).collect(Collectors.toList()))
>>>>>>> Stashed changes
                .build();
    }
}