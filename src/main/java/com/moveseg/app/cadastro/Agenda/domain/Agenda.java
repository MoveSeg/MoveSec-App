package com.moveseg.app.cadastro.Agenda.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Agenda extends AbstractAggregateRoot<AgendaId> {
    private LocalDate data;
    private ViagemId viagem;

    private Agenda(AgendaId id, ViagemId viagem, LocalDate data) {
        super(id);
        this.data = requireNonNull(data, "A data da viagem não pode ser nula");
        this.viagem = requireNonNull(viagem, "O Id da viagem não pode ser nula");
    }

    @SuppressWarnings("null")
    public static Agenda from(ViagemId viagem, LocalDate data) {
        AgendaId id = randomId(AgendaId.class);

        Agenda agenda = new Agenda(id, viagem, data);

        return agenda;
    }

}
