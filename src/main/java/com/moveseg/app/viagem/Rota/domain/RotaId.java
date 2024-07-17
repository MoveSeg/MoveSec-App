package com.moveseg.app.viagem.Rota.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class RotaId extends DomainObjectId {

    @JsonCreator
    public RotaId(@JsonProperty("rota") String uuid) {
        super(uuid);
    }
}