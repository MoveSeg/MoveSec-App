package com.moveseg.app.checklist.Item.app.view;

import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.ItemId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemListView {
    private ItemId id;
    private String descricao;
    private Boolean resposta;
    private String observacao;

    public static ItemListView of(Item item) {
        return ItemListView.builder()
                .id(item.id())
                .descricao(item.descricao().descricao())
                .resposta(item.resposta())
                .observacao(item.observacao().observacao())
                .build();
    }
}