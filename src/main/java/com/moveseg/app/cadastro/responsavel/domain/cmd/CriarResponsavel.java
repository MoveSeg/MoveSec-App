package com.moveseg.app.cadastro.responsavel.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Cpf;
import com.moveseg.app.cadastro.responsavel.domain.Genero;

import lombok.Builder;

@Builder
public class CriarResponsavel {
    public String nome;
    public Integer documento;
    public LocalDate nascimento;
    public Email email;
    public Telefone telefone;
    public Endereco endereco;
    public Genero genero;
    public Cpf cpf;
}
