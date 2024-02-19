package com.moveseg.app.cadastro.Instituto.domain;

import com.moveseg.parent.infra.domain.AbstractEntity;
import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Instituto extends AbstractEntity<InstitutoId> {
    private String nome;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    private Responsavel responsavel;

    @Embedded
    private Telefone telefone;

    @Embedded
    private Email email;

    @Builder
    private Instituto(String nome, Endereco endereco, Responsavel responsavel, Telefone telefone, Email email)
            throws Exception {
        super(randomId(InstitutoId.class));

        if (nome.isEmpty()) {
            throw new Exception("Nome não pode ser nulo");
        }
        if (endereco == null) {
            throw new Exception("Endereço não pode ser nulo");
        }
        if (responsavel == null) {
            throw new Exception("Responsavel não pode ser nulo");
        }
        if (telefone == null) {
            throw new Exception("Telefone não pode ser nulo");
        }
        if (email == null) {
            throw new Exception("Email não pode ser nulo");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.email = email;
    }

    public InstitutoForm atualizar() {
        return new InstitutoForm(form -> {
            this.nome = form.nome;
            this.endereco = form.endereco;
            this.responsavel = form.responsavel;
            this.telefone =form.telefone;
        });
    }

}
