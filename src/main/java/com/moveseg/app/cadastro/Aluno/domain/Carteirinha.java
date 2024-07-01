package com.moveseg.app.cadastro.Aluno.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Carteirinha implements ValueObject {
    private Integer carteirinha;

    public Carteirinha(Integer carteirinha) {
        this.carteirinha = carteirinha;
    }
    
    public static Carteirinha of(Integer numero) throws Exception {
        if (numero == null || numero == 0) {
            throw new Exception("O numero da sua carteirinha não pode ser nulo e nem 0");
        }
        return new Carteirinha(numero);
    }
}
