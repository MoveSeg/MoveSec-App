package com.moveseg.app.cadastro.Aluno.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AlunoForm {

    private final Consumer<AlunoForm> action;

    private String nome;
    private List<Responsavel> responsavel = new ArrayList<Responsavel>();;
    private Carteirinha carteirinha;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
    private LocalDate dataDeNascimento;

    public AlunoForm nome(String nome) {
        this.nome = nome;
        return this;
    }
    public AlunoForm responsavel(Responsavel responsavel) {
        this.responsavel.add(responsavel);
        return this;
    }

    public AlunoForm carteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
        return this;
    }

    public AlunoForm telefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }

    public AlunoForm email(Email email) {
        this.email = email;
        return this;
    }

    public AlunoForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public AlunoForm genero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public AlunoForm cpf(Cpf cpf) {
        this.cpf = cpf;
        return this;
    }

    public AlunoForm dataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
