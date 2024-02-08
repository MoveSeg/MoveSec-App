package com.moveseg.app.infra.auth.domain;

import com.moveseg.parent.infra.domain.DomainObjectId;

public class VeiculoId {
    public class VeiculoId extends DomainObjectId{

        public VeiculoId (Integer uuid) {
            super(uuid);
        }
    }
}
