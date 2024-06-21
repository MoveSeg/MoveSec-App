package com.moveseg.app.cadastro.Instituto.domain.cmd;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarInstituto {
    private String nome;
    private Endereco endereco;
    private List<String> responsaveis;
    private Telefone telefone;
    private Email email;
}
