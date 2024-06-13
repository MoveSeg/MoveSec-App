package com.moveseg.app.viagem.Rota.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public final class Numero implements ValueObject {
    private String value;

    public Numero(String value) {
        this.value = value;
    }

    public static Numero of(String numeroRota) throws Exception {
        if (numeroRota == null || numeroRota.isEmpty()) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Numero(numeroRota);
    }
}
