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
public final class Placa implements ValueObject {
    private String value;

    public Placa(String placa) {
        this.value = placa;
    }

    public static Placa of(String placa) {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("Não deve ser nulo");
        }

        return new Placa(placa);
    }
}