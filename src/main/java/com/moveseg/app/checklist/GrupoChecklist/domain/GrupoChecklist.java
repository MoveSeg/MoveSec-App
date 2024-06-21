package com.moveseg.app.checklist.GrupoChecklist.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.List;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class GrupoChecklist extends AbstractAggregateRoot<GrupoChecklistId>{
    private Nome nome;

    @ManyToMany
    private List<Checklist> checklists;

    private GrupoChecklist(GrupoChecklistId id, Nome nome, List<Checklist> checklists) {
        super(id);
        this.nome = requireNonNull(nome, "O nome do Checklist não pode ser nula");
        this.checklists = requireNonNull(checklists, "Os itens do Checklist não pode ser nulo");
    }

    public GrupoChecklistForm atualizar() {
        return new GrupoChecklistForm(form -> {
            this.nome = requireNonNull(form.nome(), "O nome do Checklist não pode ser nula");
            if (form.checklists().isEmpty()) {
                throw new IllegalArgumentException("Não pode passar uma lista vazia");
            }
            this.checklists = requireNonNull(form.checklists(), "Os itens do Checklist não pode ser nulo");
        });
    }

    public static GrupoChecklist from(Nome nome, List<Checklist> checklist){
        GrupoChecklistId id = randomId(GrupoChecklistId.class);
        
        GrupoChecklist grupoChecklist = new GrupoChecklist(id, nome, checklist);

        return grupoChecklist;
    }
} 