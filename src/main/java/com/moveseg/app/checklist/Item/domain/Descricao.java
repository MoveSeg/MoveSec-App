package com.moveseg.app.checklist.Item.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public final class Descricao {

    private String descricao;

    public Descricao(String descricao) {
        this.descricao = descricao;
    }
}
