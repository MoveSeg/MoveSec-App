package com.moveseg.app.viagem.ausencias.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.viagem.ausencias.domain.eventos.AusenciaRegistrada;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Ausencia extends AbstractAggregateRoot<AusenciaId> {

    private String motivo;
    private LocalDate data;

    private ViagemId viagem;

    private Ausencia(AusenciaId id,ViagemId viagem, String motivo) {
        super(id);
        this.motivo = requireNonNull(motivo, "O nome não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "O Id da viagem não pode ser nula");
    }

    public static Ausencia from(ViagemId viagem, String motivo) {
        AusenciaId id = randomId(AusenciaId.class);

        Ausencia ausencia = new Ausencia(id, viagem, motivo);
        ausencia.registerEvent(AusenciaRegistrada.of(id));

        return ausencia;
    }
}
