package com.moveseg.app.cadastro.responsavel.domain;

import java.time.LocalDate;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.instituto.domain.Email;
import com.moveseg.app.cadastro.instituto.domain.Endereco;
import com.moveseg.app.cadastro.instituto.domain.Telefone;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponsavelForm {
    private final Consumer<ResponsavelForm> action;

    public String nome;
    public Integer documento;
    public LocalDate nascimento;
    public Email email;
    public Telefone telefone;
    public Endereco endereco;
    public Genero genero;
    public Cpf cpf;

    public ResponsavelForm nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ResponsavelForm documento(Integer documento) {
        this.documento = documento;
        return this;
    }

    public ResponsavelForm nascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public ResponsavelForm email(Email email) {
        this.email = email;
        return this;
    }

    public ResponsavelForm telefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }

    public ResponsavelForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public ResponsavelForm genero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public ResponsavelForm cpf(Cpf cpf) {
        this.cpf = cpf;
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
