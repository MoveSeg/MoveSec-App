package com.moveseg.app.cadastro.Instituto.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Instituto extends AbstractEntity<InstitutoId> {
    private String nome;

    @Embedded
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Responsavel> responsaveis;

    @Embedded
    @AttributeOverride(column = @Column(name = "telefone"), name = "numero")
    private Telefone telefone;

    @Embedded
    private Email email;

    private Instituto(InstitutoBuilder builder) {
        super(builder.id);

        this.nome = requireNonNull(builder.nome, "Nome não pode ser nulo");
        this.endereco = requireNonNull(builder.endereco, "Endereço não pode ser nulo");
        this.responsaveis = requireNonNull(builder.responsaveis, "Responsavel não pode ser nulo");
        this.telefone = requireNonNull(builder.telefone, "Telefone não pode ser nulo");
        this.email = requireNonNull(builder.email, "Email não pode ser nulo");
    }

    public InstitutoForm atualizar() {
        return new InstitutoForm(form -> {
            this.nome = requireNonNull(form.nome(), "Nome não pode ser nulo");
            this.endereco = requireNonNull(form.endereco(), "Endereço não pode ser nulo");
            this.responsaveis = requireNonNull(form.responsaveis(), "Responsavel não pode ser nulo");
            this.telefone = requireNonNull(form.telefone(), "Telefone não pode ser nulo");
            this.email = requireNonNull(form.email(), "Email não pode ser nulo");
        });
    }

    public static class InstitutoBuilder {
        private InstitutoId id;
        private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

        public InstitutoBuilder responsavel(Responsavel responsavel) {
            responsaveis.add(responsavel);
            return this;
        }

        public Instituto build() {
            id = randomId(InstitutoId.class);

            return new Instituto(this);
        }
    }
}
