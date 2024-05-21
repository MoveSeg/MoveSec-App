package com.moveseg.app.cadastro.responsavel.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CriarResponsavel {
    private String nome;
    private LocalDate nascimento;
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
}
