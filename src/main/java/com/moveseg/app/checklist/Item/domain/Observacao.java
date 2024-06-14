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

    public static Observacao of(String observacao) throws Exception {
        if (observacao == null || observacao.isEmpty()) {
            throw new Exception("Observação não pode ser nula e nem vazia");
        }
        return new Observacao(observacao);
    }
}
