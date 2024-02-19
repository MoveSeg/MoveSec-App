package com.moveseg.app.cadastro.Instituto.domain;

import com.moveseg.app.cadastro.Instituto.infra.Phone;
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
public final class Telefone implements ValueObject {
    @Phone(message = "Numero de telefone invalido")
    private final Integer numero;

    public static Telefone of(Integer numero) throws Exception {
        if (numero == null || numero == 0) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Telefone(numero);
    }
}