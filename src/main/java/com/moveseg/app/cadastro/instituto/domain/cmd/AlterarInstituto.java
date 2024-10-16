package com.moveseg.app.cadastro.Instituto.domain.cmd;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarInstituto {
    private InstitutoId id;
    private String nome;
    private Endereco endereco;
    private List<ResponsavelId> responsaveis;
    private Telefone telefone;
    private Email email;
}