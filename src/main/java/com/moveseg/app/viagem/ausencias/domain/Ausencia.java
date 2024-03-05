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
    //TODO: Adicionar a Viagem

    private Ausencia(AusenciaId id, String motivo) {
        super(id);
        this.motivo = requireNonNull(motivo, "O nome não deve ser nulo");
        this.data = LocalDate.now();
    }

    public static Ausencia of(String motivo) {
        AusenciaId id = randomId(AusenciaId.class);
        
        Ausencia ausencia = new Ausencia(id, motivo);
        ausencia.registerEvent(AusenciaRegistrada.of(id));

        return ausencia;
    }
}
