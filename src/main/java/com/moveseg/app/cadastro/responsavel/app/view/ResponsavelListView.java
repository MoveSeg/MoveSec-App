package com.moveseg.app.cadastro.responsavel.app.view;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponsavelListView {
    private ResponsavelId id;
    private String nome;
    private String nascimento;
    private String email;
    private String telefone;
    private String logradouro;
    private Integer numero;
    private String genero;
    private String cpf;

    public static ResponsavelListView of(Responsavel responsavel) {
        return ResponsavelListView.builder()
                .id(responsavel.id())
                .nome(responsavel.nome())
                .nascimento(responsavel.nascimento().toString())
                .email(responsavel.email().email())
                .telefone(responsavel.telefone().telefone())
                .logradouro(responsavel.endereco().logradouro())
                .numero(responsavel.endereco().numero())
                .genero(responsavel.genero().toString())
                .cpf(responsavel.cpf().cpf())
                .build();
    }

}