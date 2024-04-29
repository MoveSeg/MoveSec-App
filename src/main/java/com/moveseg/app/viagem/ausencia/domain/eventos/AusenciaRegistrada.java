package com.moveseg.app.viagem.ausencia.domain.eventos;

import java.time.Instant;

import com.moveseg.app.viagem.ausencia.domain.AusenciaId;
import com.moveseg.parent.infra.domain.DomainEvent;

import lombok.Getter;

@Getter
public final class AusenciaRegistrada implements DomainEvent {
    private final AusenciaId id;
    private final Instant occurredOn;

    public AusenciaRegistrada(AusenciaId id) {
        this.id = id;
        occurredOn = Instant.now();
    }

    public static AusenciaRegistrada of(AusenciaId id) {
        return new AusenciaRegistrada(id);
    }
}
