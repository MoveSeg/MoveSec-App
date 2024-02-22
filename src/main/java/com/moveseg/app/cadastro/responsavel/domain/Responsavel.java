package com.moveseg.app.cadastro.responsavel.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public final class Responsavel extends AbstractEntity<ResponsavelId> {
    private String nome;

    private Responsavel(@Nonnull ResponsavelId id, String nome) {
        super(id);
        this.nome = requireNonNull(nome, "Responsavel não pode ser nulo");
    }

    public static Responsavel of(String nome)  {
        return new Responsavel(randomId(ResponsavelId.class), nome);
    }
}
