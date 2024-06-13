package com.moveseg.app.checklist.Item.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public final class Observacao {
    private String observacao;

    public Observacao(String observacao){
        this.observacao = observacao;
    }
}
