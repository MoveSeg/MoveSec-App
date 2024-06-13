package com.moveseg.app.checklist.Item.domain;

import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;


import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Item extends AbstractAggregateRoot<ItemId> {
    private Descricao descricao;
    private Boolean resposta;
    private Observacao observacao;

    private Item(ItemId id, Descricao descricao, Boolean pergunta, Observacao observacao) {
        super(id);
        this.descricao = requireNonNull(descricao, "A descrição da pergunta não pode ser nula");
        this.resposta = requireNonNull(resposta, "A resposta da pergunta pode estar vazia");
        this.observacao = requireNonNull(observacao, "A observação da pergunta não pode ser nula");
    }

    public ItemForm atualizar() {
        return new ItemForm(form -> {
            this.descricao = requireNonNull(descricao, "A descrição da pergunta não pode ser nula");
            this.resposta = requireNonNull(resposta, "O Id da viagem não pode ser nula");
            this.observacao = requireNonNull(observacao, "O Id da viagem não pode ser nula");
        });
    }

    @SuppressWarnings("null")
    public static Item from(Descricao descricao, Boolean pergunta, Observacao observacao) {
        ItemId id = randomId(ItemId.class);

        Item item = new Item(id, descricao, pergunta, observacao);

        return item;
    }

}