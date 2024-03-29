package com.moveseg.app.cadastro.Aluno.domain.cmd;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.cadastro.Aluno.domain.Carteirinha;
import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarAluno {
    private AlunoId id;
    private String nome;
    private Responsavel responsavel;
    private Carteirinha carteirinha;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
}
