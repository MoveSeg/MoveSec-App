package com.moveseg.app.cadastro.cadastroInstituicao.domain;

import java.util.UUID;

import com.moveseg.parent.infra.domain.AbstractEntity;
import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
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

    @Builder
    private Instituto(String nome, Endereco endereco, Responsavel responsavel, Telefone telefone, Email email) throws Exception{
        super(randomId(InstitutoId.class));
       
        if (nome.isEmpty()){
            throw new Exception("Nome não pode ser nulo");
        }
        if (endereco == null){
            throw new Exception("Endereço não pode ser nulo");
        }
        if (responsavel == null){
            throw new Exception("Responsavel não pode ser nulo");
        }
        if (telefone == null){
            throw new Exception("Telefone não pode ser nulo");
        }
        if (email == null){
            throw new Exception("Email não pode ser nulo");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
    }
}
