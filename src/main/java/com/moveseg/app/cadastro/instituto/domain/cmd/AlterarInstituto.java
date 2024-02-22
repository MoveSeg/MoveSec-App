package com.moveseg.app.cadastro.instituto.domain.cmd;

import com.moveseg.app.cadastro.instituto.domain.Email;
import com.moveseg.app.cadastro.instituto.domain.Endereco;
import com.moveseg.app.cadastro.instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarInstituto {
    private InstitutoId id;
    private String nome;
    private Endereco endereco;
    private Responsavel responsavel;
    private Telefone telefone;
    private Email email;
}
