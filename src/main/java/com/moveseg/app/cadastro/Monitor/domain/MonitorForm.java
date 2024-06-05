package com.moveseg.app.cadastro.Monitor.domain;

import java.time.LocalDate;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MonitorForm {
    private final Consumer<MonitorForm> action;

    private String nome;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
    private LocalDate dataDeNascimento;

    public MonitorForm nome(String nome) {
        this.nome = nome;
        return this;
    }

    public MonitorForm telefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }

    public MonitorForm email(Email email) {
        this.email = email;
        return this;
    }

    public MonitorForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public MonitorForm genero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public MonitorForm cpf(Cpf cpf) {
        this.cpf = cpf;
        return this;
    }

    public MonitorForm dataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
