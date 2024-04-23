package com.moveseg.app.cadastro.responsavel.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.Carteirinha;
import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PRIVATE, force = true)

@Entity
public final class Responsavel extends AbstractEntity<ResponsavelId> {

    @Embedded
    @AttributeOverride(column = @Column(name = "email"), name = "value")
    private Email email;

    @Embedded
    @AttributeOverride(column = @Column(name = "endereco"), name = "numero")
    private Endereco endereco;

    @Embedded
    @AttributeOverride(column = @Column(name = "telefone"), name = "numero")
    private Telefone telefone;

    @Embedded
    @AttributeOverride(column = @Column(name = "genero"), name = "value")
    private Genero genero;

    @Embedded
    @AttributeOverride(column = @Column(name = "cpf"), name = "numero")
    private Cpf cpf;

    private String nome;


    private LocalDate nascimento;

    private Responsavel(ResponsavelBuilder builder) {
        super(builder.id);
        this.nome = requireNonNull(builder.nome, "O nome não deve ser inválido");
        this.nascimento = requireNonNull(builder.nascimento, "O nascimento não deve ser nulo");
        this.email = requireNonNull(builder.email, "O email não deve ser nulo");
        this.endereco = requireNonNull(builder.endereco, "O endereço não deve ser nulo");
        this.telefone = requireNonNull(builder.telefone, "O telefone não deve ser nulo");
        this.genero = requireNonNull(builder.genero, "O gênero não deve ser nulo");
        this.cpf = requireNonNull(builder.cpf, "O cpf não deve ser nulo");
    }

    public ResponsavelForm update() {
        return new ResponsavelForm(form -> {
            this.nome = requireNonNull(form.nome(), "O nome não deve ser nulo");
            this.nascimento = requireNonNull(form.nascimento(), "O nascimento não deve ser nulo");
            this.email = requireNonNull(form.email(), "O email não deve ser nulo");
            this.endereco = requireNonNull(form.endereco(), "Endereço não pode ser nulo");
            this.telefone = requireNonNull(form.telefone(), "O telefone não deve ser nulo");
            this.genero = requireNonNull(form.genero(), "O genero não deve ser nulo");
            this.cpf = requireNonNull(form.cpf(), "O cpf não deve ser nulo");
        });
    }

    public static class ResponsavelBuilder {
        private ResponsavelId id;

        public Responsavel build() {
            id = randomId(ResponsavelId.class);

            return new Responsavel(this);

        }
    }
}
