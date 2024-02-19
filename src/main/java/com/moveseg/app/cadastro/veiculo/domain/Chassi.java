package com.moveseg.app.cadastro.veiculo.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Chassi implements ValueObject {
    private final String value;

    public static Chassi of(String chassi) {

        if (chassi == null || chassi.isEmpty()) {
            throw new IllegalArgumentException("Não pode ser nulo");
        }

        return new Chassi(chassi);
    }
}
