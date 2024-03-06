package com.moveseg.app.cadastro.Veiculo.domain;

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
public final class Placa implements ValueObject {
    private String value;

    public static Placa of(String placa) {
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("Não deve ser nulo");
        }

        return new Placa(placa);
    }
}