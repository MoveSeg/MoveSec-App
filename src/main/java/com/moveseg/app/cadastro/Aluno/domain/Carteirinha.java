package com.moveseg.app.cadastro.Aluno.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Carteirinha {
    private Integer numero;

    public static Carteirinha of(Integer numero) throws Exception {
        if (numero == null || numero == 0) {
            throw new Exception("O numero da sua carteirinha não pode ser nulo e nem 0");
        }
        return new Carteirinha(numero);
    }
}
