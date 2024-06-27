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

    public static Descricao of(String descricao) throws Exception {
        if (descricao == null || descricao.isEmpty()) {
            throw new Exception("Descrição não pode ser nula e nem vazia");
        }
        return new Descricao(descricao);
    }
}
