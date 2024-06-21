package com.moveseg.app.checklist.GrupoChecklist.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GrupoChecklistForm {
    private final Consumer<GrupoChecklistForm> action;

       private Nome nome;
       private List<Checklist> checklists = new ArrayList<Checklist>();


      public GrupoChecklistForm nome(Nome nome){
        this.nome = nome;
        return this;
    }

    public GrupoChecklistForm checklist(List<Checklist> checklist){
        this.checklists.addAll(checklist);
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
