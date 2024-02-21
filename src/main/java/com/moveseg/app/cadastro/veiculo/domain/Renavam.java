package com.moveseg.app.cadastro.veiculo.domain;

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
public final class Renavam implements ValueObject {
    private String value;

    public static Renavam of(String renavam) {
        if (renavam == null || renavam.isEmpty()) {
            throw new IllegalArgumentException("Não deve ser nulo");
        }
        return new Renavam(renavam);
    }

}