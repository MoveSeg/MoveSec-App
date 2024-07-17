package com.moveseg.app.cadastro.veiculo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class VeiculoId extends DomainObjectId {
 @JsonCreator
    public VeiculoId(@JsonProperty("veiculo") String uuid) {
        super(uuid);
    }
}
