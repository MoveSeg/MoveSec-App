package com.moveseg.app.cadastro.veiculo.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Renavam implements ValueObject {
    private String renavam;

    public Renavam(String renavam) {
        this.renavam = renavam;
    }

    public static Renavam of(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Não deve ser nulo");
        }
        return new Renavam(value);
    }

}