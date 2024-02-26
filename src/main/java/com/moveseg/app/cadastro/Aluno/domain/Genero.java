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
public class Genero {

    private String genero;

    public static Genero of(String genero) throws Exception {
        if (genero == null || genero.isEmpty()) {
            throw new Exception("Seu genero não pode estar vazio");
        }
        return new Genero(genero);
    }

}
