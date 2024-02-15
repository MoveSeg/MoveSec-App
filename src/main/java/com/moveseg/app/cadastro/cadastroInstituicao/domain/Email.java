package com.moveseg.app.cadastro.cadastroInstituicao.domain;

import com.moveseg.parent.infra.domain.ValueObject;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.AccessLevel;
import lombok.Getter;

@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Email implements ValueObject{
    private final String email;

    public static Email of(String email) {
        return new Email(email);
    }
}
