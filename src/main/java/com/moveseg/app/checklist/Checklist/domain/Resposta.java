package com.moveseg.app.checklist.Checklist.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Resposta extends AbstractEntity<RespostaId> {
    private GrupoChecklistId grupoChecklist;
    private ChecklistId checklist;
    private ItemId item;
    private Long IdUsuario;
    private Boolean resposta;
    private LocalDate data;

     private Resposta(RespostaBuilder builder) {
        super(builder.id);
        this.grupoChecklist = requireNonNull(builder.grupoChecklist, "O id do grupo checklist não deve ser nulo");
        this.checklist = requireNonNull(builder.checklist, "O id do checklist não deve ser nulo");
        this.item = requireNonNull(builder.item, "O id do item não deve ser nulo");
        this.IdUsuario = requireNonNull(builder.IdUsuario, "O id do usuario não deve ser nulo");
        this.resposta = requireNonNull(builder.resposta, "A resposta não pode estar vazia");
        this.data = requireNonNull(builder.data, "A data não pode ser nula");
    }

    public static class RespostaBuilder {
        private RespostaId id;

        public Resposta build() {
            id = randomId(RespostaId.class);

            return new Resposta(this);
        }
    }
}
