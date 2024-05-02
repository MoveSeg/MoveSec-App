package com.moveseg.app.cadastro.Monitor.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;

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

@Entity
@Getter
@Builder
@NoArgsConstructor(access = PRIVATE, force = true)

public class Monitor extends AbstractEntity<MonitorId> {
    private String nome;

    @Embedded
    @AttributeOverride(column = @Column(name = "telefone"), name = "numero")
    private Telefone telefone;

    @Embedded
    @AttributeOverride(column = @Column(name = "email"), name = "value")
    private Email email;

    @Embedded
    @AttributeOverride(column = @Column(name = "endereco"), name = "numero")
    private Endereco endereco;

    @Embedded
    @AttributeOverride(column = @Column(name = "genero"), name = "value")
    private Genero genero;

    @Embedded
    @AttributeOverride(column = @Column(name = "cpf"), name = "numero")
    private Cpf cpf;

    private LocalDate dataDeNascimento;

    private Monitor(MonitorBuilder builder) {
        super(builder.id);
        this.nome = requireNonNull(builder.nome, "O nome não deve ser nulo");
        this.telefone = requireNonNull(builder.telefone, "O telefone não pode ser invalido");
        this.email = requireNonNull(builder.email, "O Email não pode ser inválido");
        this.endereco = requireNonNull(builder.endereco, "O endereco não deve ser nulo");
        this.genero = requireNonNull(builder.genero, "O Genero não deve ser nulo");
        this.cpf = requireNonNull(builder.cpf, "O CPF não deve ser nula");
        this.dataDeNascimento = requireNonNull(builder.dataDeNascimento, "A sua data de nascimanto não deve ser nula");
    }

    public MonitorForm update() {
        return new MonitorForm(form -> {
            this.nome = requireNonNull(form.nome(), "Nome não pode ser nulo");
            this.telefone = requireNonNull(form.telefone(), "Telefone não pode ser nulo");
            this.email = requireNonNull(form.email(), "Email não pode ser nulo");
            this.endereco = requireNonNull(form.endereco(), "Endereço não pode ser nulo");
            this.genero = requireNonNull(form.genero(), "Gênero não pode ser nulo");
            this.cpf = requireNonNull(form.cpf(), "Cpf não pode ser nulo");
            this.dataDeNascimento = requireNonNull(form.dataDeNascimento(), "Cpf não pode ser nulo");
        });
    }

    public static class MonitorBuilder {
        private MonitorId id;

        public Monitor build() {
            id = randomId(MonitorId.class);

            return new Monitor(this);

        }
    }
}
