package com.moveseg.app.cadastro.cadastroInstituiocao.domain;

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
public final class Telefone implements ValueObject{
    private final Integer numero;

    public static Telefone of(Integer numero){
        return new Telefone(numero);
    }
}