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
public class ItemFormView {
    private ItemId id;
    private String descricao;
    private Boolean resposta;
    private String observacao;

    public static ItemFormView of(Item item) {
        return ItemFormView.builder()
                .id(item.id())
                .descricao(item.descricao().descricao())
                .resposta(item.resposta())
                .observacao(item.observacao().observacao())
                .build();
    }
}
