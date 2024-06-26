package com.moveseg.app.checklist.Checklist.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.List;

import com.moveseg.app.checklist.Checklist.domain.Resposta.RespostaBuilder;
import com.moveseg.app.checklist.Checklist.domain.cmd.Responder;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Checklist extends AbstractAggregateRoot<ChecklistId> {
    private Nome nome;

    @ManyToMany
    private List<Item> itens;

    private Checklist(ChecklistId id, Nome nome, List<Item> itens) {
        super(id);
        this.nome = requireNonNull(nome, "O nome do Checklist não pode ser nula");
        this.itens = requireNonNull(itens, "Os itens do Checklist não pode ser nulo");
    }

    public ChecklistForm atualizar() {
        return new ChecklistForm(form -> {
            this.nome = requireNonNull(form.nome(), "O nome do Checklist não pode ser nula");
            if (form.itens().isEmpty()) {
                throw new IllegalArgumentException("Não pode passar uma lista vazia");
            }
            this.itens = requireNonNull(form.itens(), "Os itens do Checklist não pode ser nulo");
        });
    }

    public static Checklist from(Nome nome, List<Item> itens) {
        ChecklistId id = randomId(ChecklistId.class);

        Checklist checklist = new Checklist(id, nome, itens);

        return checklist;
    }

    public static Resposta responder(@NonNull @Valid Responder cmd) {
        Resposta resposta = Resposta.builder()
                .grupoChecklist(cmd.grupoChecklist())
                .checklist(cmd.checklist())
                .item(cmd.item())
                .IdUsuario(cmd.idUsuario())
                .resposta(cmd.resposta())
                .data(cmd.data())
                .build();
        return resposta;
    }
}
