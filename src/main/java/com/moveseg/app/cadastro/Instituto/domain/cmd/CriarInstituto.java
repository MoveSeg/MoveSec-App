package com.moveseg.app.cadastro.Instituto.domain.cmd;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Responsavel;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarInstituto {
    public String nome;
    public Endereco endereco;
    public Responsavel responsavel;
    public Telefone telefone;
    public Email email;
}
