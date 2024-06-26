package com.moveseg.app.viagem.Programacao.domain;

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
public class Programacao extends AbstractAggregateRoot<ProgramacaoId> {
    private LocalDate data;
    private ViagemId viagem;

    private Programacao(ProgramacaoId id, ViagemId viagem, LocalDate data) {
        super(id);
        this.data = requireNonNull(data, "A data da viagem não pode ser nula");
        this.viagem = requireNonNull(viagem, "O Id da viagem não pode ser nula");
    }

    @SuppressWarnings("null")
    public static Programacao from(ViagemId viagem, LocalDate data) {
        ProgramacaoId id = randomId(ProgramacaoId.class);

        Programacao programacao = new Programacao(id, viagem, data);

        return programacao;
    }

}
