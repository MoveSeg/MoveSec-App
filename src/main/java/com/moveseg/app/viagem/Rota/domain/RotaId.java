package com.moveseg.app.viagem.Rota.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import com.moveseg.parent.infra.domain.DomainObjectId;

public class RotaId extends DomainObjectId {

    public RotaId(String uuid) {
        super(uuid);
    }
}