package com.moveseg.app.viagem.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class ViagemId extends DomainObjectId {
    @JsonCreator
    public ViagemId(@JsonProperty("viagem") String uuid){
        super(uuid);
    }
}
