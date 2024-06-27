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
    private Integer value;

    public Carteirinha(Integer carteirinha) {
        this.value = carteirinha;
    }

    public static Carteirinha of(Integer carteirinha) throws Exception {
        if (carteirinha == null || carteirinha == 0) {
            throw new Exception("O numero da sua carteirinha não pode ser nulo e nem 0");
        }
        return new Carteirinha(carteirinha);
    }
}
