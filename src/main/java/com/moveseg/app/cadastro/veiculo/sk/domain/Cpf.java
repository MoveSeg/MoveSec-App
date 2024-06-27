package com.moveseg.app.cadastro.veiculo.sk.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Cpf implements ValueObject {
    private String cpf;

    public Cpf(String cpf) {
        this.cpf = cpf;
    }

    public static Cpf of(String cpf) throws Exception {
        if (cpf == null || cpf.isEmpty()) {
            throw new Exception("O seu CPF não pode ser nulo e nem 0");
        }
        return new Cpf(cpf);
    }

}