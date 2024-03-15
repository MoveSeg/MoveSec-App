package com.moveseg.app.viagem.Ocorrencia.events;

import java.time.Instant;

import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.parent.infra.domain.DomainEvent;

import lombok.Getter;

@Getter
public final class OcorrenciaRealizada implements DomainEvent{
    
    private final OcorrenciaId id;
    private final Instant occurredOn;

    public OcorrenciaRealizada(OcorrenciaId id){
        this.id = id;
        occurredOn = Instant.now();
    }

    public static DomainEvent of(OcorrenciaId id){
        return new OcorrenciaRealizada(id);
    }
}

