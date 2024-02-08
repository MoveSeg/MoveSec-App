package com.moveseg.app.infra.auth.domain;

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



public final class Renavam implements ValueObject {
    private final String marca;
    private final String cor;
    private final String alteracoes_devido_a_batidas;



public static Renavam of(String marca, String cor, String alteracoes_devido_a_batidas){
          return new Renavam(marca, cor, alteracoes_devido_a_batidas);
}

}