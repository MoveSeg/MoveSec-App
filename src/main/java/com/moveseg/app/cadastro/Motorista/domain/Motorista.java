package com.moveseg.app.cadastro.Motorista.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Motorista extends AbstractEntity<MotoristaId> {

    @Embedded
    private Email email;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Telefone telefone;

    private Genero genero;

    @Embedded
    private Cpf cpf;

    private String nome;

    private LocalDate nascimento;

    private Motorista(MotoristaBuilder builder) {
        super(builder.id);
        this.nome = requireNonNull(builder.nome, "O nome não deve ser inválido");
        this.nascimento = requireNonNull(builder.nascimento, "O nascimento não deve ser nulo");
        this.email = requireNonNull(builder.email, "O email não deve ser nulo");
        this.endereco = requireNonNull(builder.endereco, "O endereço não deve ser nulo");
        this.telefone = requireNonNull(builder.telefone, "O telefone não deve ser nulo");
        this.genero = requireNonNull(builder.genero, "O gênero não deve ser nulo");
        this.cpf = requireNonNull(builder.cpf, "O cpf não deve ser nulo");
    }
    public MotoristaForm atualizar() {
        return new MotoristaForm(form -> {
            this.nome = requireNonNull(form.nome(), "O nome não deve ser nulo");
            this.nascimento = requireNonNull(form.nascimento(), "O nascimento não deve ser nulo");
            this.email = requireNonNull(form.email(), "O email não deve ser nulo");
            this.endereco = requireNonNull(form.endereco(), "Endereço não pode ser nulo");
            this.telefone = requireNonNull(form.telefone(), "O telefone não deve ser nulo");
            this.genero = requireNonNull(form.genero(), "O genero não deve ser nulo");
            this.cpf = requireNonNull(form.cpf(), "O cpf não deve ser nulo");
        });
    }

    public static class MotoristaBuilder {
        private MotoristaId id;

        public Motorista build() {
            id = randomId(MotoristaId.class);

            return new Motorista(this);
        }
    }

}
