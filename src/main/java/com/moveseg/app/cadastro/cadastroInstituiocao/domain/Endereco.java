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
public final class Endereco implements ValueObject{
    private final String logradouro;
    private final Integer numero;

    public static Endereco of(String logradouro, Integer numero){
        return new Endereco(logradouro, numero);
    }
}
