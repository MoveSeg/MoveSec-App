package com.moveseg.app.cadastro.responsavel.domain;

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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Genero implements ValueObject {
    private String value;

    public static Genero of(String genero) {
        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("Não deve ser nulo");
        }
        return new Genero(genero);
    }

}