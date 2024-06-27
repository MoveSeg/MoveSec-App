package com.moveseg.app.checklist.Checklist.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.checklist.Item.domain.Item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class ChecklistForm {
      private final Consumer<ChecklistForm> action;

       private Nome nome;
       private List<Item> itens = new ArrayList<Item>();


      public ChecklistForm nome(Nome nome){
        this.nome = nome;
        return this;
    }

    public ChecklistForm itens(List<Item> item){
        this.itens.addAll(item);
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
