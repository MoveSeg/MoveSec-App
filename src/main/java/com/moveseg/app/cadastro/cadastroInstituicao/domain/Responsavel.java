package com.moveseg.app.cadastro.cadastroInstituicao.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Responsavel implements ValueObject{
    private final String Nome;

    @OneToOne
    public static Responsavel of(String nome){
        return new Responsavel(nome);
    }
}
