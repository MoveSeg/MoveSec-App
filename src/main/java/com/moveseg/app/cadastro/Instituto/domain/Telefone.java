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

    private String telefone;

    public Telefone(String telefone) {
        this.telefone = telefone;
    }

    public static Telefone of(String telefone) throws Exception {
        if (telefone == null || telefone.isEmpty()) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Telefone(telefone);
    }
}