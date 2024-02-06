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
public final class Responsavel implements ValueObject{
    private final String Nome;

    public static Responsavel of(String nome){
        return new Responsavel(nome);
    }
}
