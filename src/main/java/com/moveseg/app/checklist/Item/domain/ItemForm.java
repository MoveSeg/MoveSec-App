package com.moveseg.app.checklist.Item.domain;

import java.util.function.Consumer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemForm {

    private final Consumer<ItemForm> action;

    private Descricao descricao;
    private Boolean resposta;
    private Observacao observacao;

    public ItemForm descricao(Descricao descricao){
        this.descricao = descricao;
        return this;
    }

    public ItemForm resposta(Boolean resposta){
        this.resposta = resposta;
        return this;
    }

    public ItemForm observacao(Observacao observacao){
        this.observacao = observacao;
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
