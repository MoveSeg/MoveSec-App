package com.moveseg.app.viagem.Rota.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Numero implements ValueObject {
    private String value;

    public static Numero of(String numero) throws Exception {
        if (numero == null || numero.isEmpty()) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Numero(numero);
    }
}
