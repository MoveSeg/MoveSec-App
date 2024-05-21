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
    private String numero;

    public Cpf(String numero) {
        this.numero = numero;
    }

    public static Cpf of(String numero) throws Exception{
        if(numero == null || numero.isEmpty()) {
            throw new Exception("O seu CPF não pode ser nulo e nem 0");
        }
        return new Cpf(numero);
    }

}