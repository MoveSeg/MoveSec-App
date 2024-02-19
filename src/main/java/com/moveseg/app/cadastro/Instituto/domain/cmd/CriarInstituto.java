package com.moveseg.app.cadastro.instituto.domain.cmd;

import com.moveseg.app.cadastro.instituto.domain.Email;
import com.moveseg.app.cadastro.instituto.domain.Endereco;
import com.moveseg.app.cadastro.instituto.domain.Responsavel;
import com.moveseg.app.cadastro.instituto.domain.Telefone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarInstituto {
    private String nome;
    private Endereco endereco;
    private Responsavel responsavel;
    private Telefone telefone;
    private Email email;
}