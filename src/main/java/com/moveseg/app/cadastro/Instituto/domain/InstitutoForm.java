package com.moveseg.app.cadastro.Instituto.domain;

import java.util.function.Consumer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstitutoForm {

    private final Consumer<InstitutoForm> action;

    public String nome;
    public Endereco endereco;
    public Responsavel responsavel;
    public Telefone telefone;
    public Email email;

    public InstitutoForm nome(String nome) {
        this.nome = nome;
        return this;
    }

    public InstitutoForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public InstitutoForm responsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
        return this;
    }

    public InstitutoForm telefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }

    public InstitutoForm email(Email email) {
        this.email = email;
        return this;
    }

    public void aplicar(){
        action.accept(this);
    }
}
