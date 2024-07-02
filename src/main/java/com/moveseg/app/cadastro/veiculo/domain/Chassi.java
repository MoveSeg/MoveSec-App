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

public final class Chassi implements ValueObject {
    private String chassi;

    public Chassi(String chassi) {
        this.chassi = chassi;
    }

    public static Chassi of(String chassi) {

        if (chassi == null || chassi.isEmpty()) {
            throw new IllegalArgumentException("Não pode ser nulo");
        }

        return new Chassi(chassi);
    }
}
