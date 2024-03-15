package com.moveseg.app.cadastro.Aluno.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;
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
public class Aluno extends AbstractEntity<AlunoId> {
    private String nome;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Responsavel> responsaveis;

    @Embedded
    @AttributeOverride(column = @Column(name = "carteirinha"), name = "numero")
    private Carteirinha carteirinha;

    @Embedded
    @AttributeOverride(column = @Column(name = "telefone"), name = "numero")
    private Telefone telefone;

    @Embedded
    private Email email;

    @Embedded
    private Endereco endereco;
    
    private Genero genero;

    @Embedded
    @AttributeOverride(column = @Column(name = "cpf"), name = "numero")
    private Cpf cpf;

    private LocalDate dataDeNascimento;

    private Aluno(AlunoBuilder builder) {
        super(builder.id);
        this.nome = requireNonNull(builder.nome, "O nome não deve ser nulo");
        this.responsaveis = requireNonNull(builder.responsaveis, "O nome do reaponsável não deve ser nulo");
        this.carteirinha = requireNonNull(builder.carteirinha, "A carteirinha não deve ser inválida");
        this.telefone = requireNonNull(builder.telefone, "O telefone não pode ser invalido");
        this.email = requireNonNull(builder.email, "O Email não pode ser inválido");
        this.endereco = requireNonNull(builder.endereco, "O endereco não deve ser nulo");
        this.genero = requireNonNull(builder.genero, "O Genero não deve ser nulo");
        this.cpf = requireNonNull(builder.cpf, "O CPF não deve ser nula");
        this.dataDeNascimento = requireNonNull(builder.dataDeNascimento, "A sua data de nascimanto não deve ser nula");
    }

    public AlunoForm atualizar() {
        return new AlunoForm(form -> {
            this.nome = requireNonNull(form.nome(), "Nome não pode ser nulo");
            this.responsaveis = requireNonNull(form.responsavel(), "Responsavel não pode ser nulo");
            this.carteirinha = requireNonNull(form.carteirinha(), "Carteirinha não Pode ser nula e nem 0");
            this.telefone = requireNonNull(form.telefone(), "Telefone não pode ser nulo");
            this.email = requireNonNull(form.email(), "Email não pode ser nulo");
            this.endereco = requireNonNull(form.endereco(), "Endereço não pode ser nulo");
            this.genero = requireNonNull(form.genero(), "Gênero não pode ser nulo");
            this.cpf = requireNonNull(form.cpf(), "Cpf não pode ser nulo");
            this.dataDeNascimento = requireNonNull(form.dataDeNascimento(), "Cpf não pode ser nulo");
        });
    }

    public static class AlunoBuilder {
        private AlunoId id;
        private List<Responsavel> responsaveis = new ArrayList<Responsavel>();

        public AlunoBuilder responsavel(Responsavel responsavel) {
            responsaveis.add(responsavel);
            return this;
        }

        public Aluno build() {
            id = randomId(AlunoId.class);

            return new Aluno(this);
        }
    }



}
