package com.moveseg.app.cadastro.Instituto.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public final class Telefone implements ValueObject {
    private String numero;

    public Telefone(String numero) {
        this.numero = numero;
    }

    public static Telefone of(String numero) throws Exception {
        if (numero == null || numero.isEmpty()) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Telefone(numero);
    }
}