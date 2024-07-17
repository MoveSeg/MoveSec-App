package com.moveseg.app.cadastro.Motorista.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class MotoristaId extends DomainObjectId {
    @JsonCreator
    public MotoristaId(@JsonProperty("motorista")String uuid) {
        super(uuid);
    }

}
