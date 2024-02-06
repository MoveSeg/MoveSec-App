package com.moveseg.app.cadastro.cadastroInstituiocao.domain;

import java.util.UUID;

import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Instituto extends AbstractEntity<InstitutoId>{

    @NotBlank
    private final String nome;

    @NotBlank
    @Embedded
    private final Endereco endereco;

    @NotBlank
    @OneToOne
    private final Responsavel responsavel;
    
    @NotBlank
    @Embedded
    private final Telefone telefone;
        
    @NotBlank
    @Embedded
    private final Email email;

}
