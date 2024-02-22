package com.moveseg.app.cadastro.instituto.domain;

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
public final class Endereco {
    private String logradouro;
    private Integer numero;

    public static Endereco of(String logradouro, Integer numero) throws Exception {
        // assert logradouro.isEmpty() : "Logradouro não pode ser nulo";
        if (logradouro == null || logradouro.isEmpty()) {
            throw new Exception("Logradouro não pode ser nulo e nem vazio");
        }
        if (numero == null || numero == 0) {
            throw new Exception("Numero não pode ser nulo e nem 0");
        }
        return new Endereco(logradouro, numero);
    }
}
