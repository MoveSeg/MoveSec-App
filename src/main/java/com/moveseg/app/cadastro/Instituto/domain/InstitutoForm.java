package com.moveseg.app.cadastro.instituto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InstitutoForm {

    private final Consumer<InstitutoForm> action;

    private String nome;
    private Endereco endereco;
    private List<Responsavel> responsaveis = new ArrayList<Responsavel>();
    private Telefone telefone;
    private Email email;

    public InstitutoForm nome(String nome) {
        this.nome = nome;
        return this;
    }

    public InstitutoForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public InstitutoForm responsavel(Responsavel responsavel) {
        this.responsaveis.add(responsavel);
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

    public void aplicar() {
        action.accept(this);
    }
}
