package com.moveseg.app.checklist.Resposta.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Resposta extends AbstractEntity<RespostaId> {

    @ManyToOne
    private GrupoChecklist grupoChecklist;

    @ManyToOne
    private Checklist checklist;

    @ManyToOne
    private Item item;
    private Long IdUsuario;
    private Boolean resposta;
    private LocalDate data;

     private Resposta(RespostaBuilder builder) {
        super(builder.id);
        this.grupoChecklist = requireNonNull(builder.grupoChecklist, "O grupo checklist não deve ser nulo");
        this.checklist = requireNonNull(builder.checklist, "O checklist não deve ser nulo");
        this.item = requireNonNull(builder.item, "O item não deve ser nulo");
        this.IdUsuario = requireNonNull(builder.IdUsuario, "O id do usuario não deve ser nulo");
        this.resposta = requireNonNull(builder.resposta, "A resposta não pode estar vazia");
        this.data = LocalDate.now();
    }

    public static class RespostaBuilder {
        private RespostaId id;

        public Resposta build() {
            id = randomId(RespostaId.class);

            return new Resposta(this);
        }
    }
}