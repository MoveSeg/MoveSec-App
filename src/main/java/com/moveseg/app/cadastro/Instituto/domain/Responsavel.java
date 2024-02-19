package com.moveseg.app.cadastro.instituto.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Responsavel implements ValueObject {
    private final String nome;

    @ManyToMany
    public static Responsavel of(String nome) throws Exception {
        if (nome == null||nome.isEmpty()) {
            throw new Exception("Responsavel não pode ser nulo");
        }
        return new Responsavel(nome);
    }
}
