package com.moveseg.app.cadastro.Instituto.domain.cmd;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarInstituto {
    private String nome;
    private Endereco endereco;
    private ResponsavelId responsavel;
    private Telefone telefone;
    private Email email;
}
