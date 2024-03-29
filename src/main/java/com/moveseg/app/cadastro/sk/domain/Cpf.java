package com.moveseg.app.cadastro.sk.domain;

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
public class Cpf implements ValueObject {
    private final String numero;

    public static Cpf of(String numero) throws Exception{
        if (numero == null || numero.isEmpty()) {
            throw new Exception("O seu CPF não pode ser nulo e nem 0");
        }
        return new Cpf(numero);
    }

}