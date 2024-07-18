package com.moveseg.app.cadastro.Motorista.domain;

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
public class MotoristaForm {

    private final Consumer<MotoristaForm> action;

    public String nome;
    public Integer documento;
    public LocalDate nascimento;
    public Email email;
    public Telefone telefone;
    public Endereco endereco;
    public Genero genero;
    public Cpf cpf;

    public MotoristaForm nome(String nome) {
        this.nome = nome;
        return this;
    }

    public MotoristaForm documento(Integer documento) {
        this.documento = documento;
        return this;
    }

    public MotoristaForm nascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public MotoristaForm email(Email email) {
        this.email = email;
        return this;
    }

    public MotoristaForm telefone(Telefone telefone) {
        this.telefone = telefone;
        return this;
    }

    public MotoristaForm endereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public MotoristaForm genero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public MotoristaForm cpf(Cpf cpf) {
        this.cpf = cpf;
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
