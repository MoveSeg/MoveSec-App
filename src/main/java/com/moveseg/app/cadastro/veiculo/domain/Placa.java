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
public final class Placa implements ValueObject {
    private final String value;

    public static Placa of(String placa) {
        assert !placa.isEmpty(): "Placa não pode ser vazio";
        throw new IllegalArgumentException ("Não deve ser nullo");
}
}