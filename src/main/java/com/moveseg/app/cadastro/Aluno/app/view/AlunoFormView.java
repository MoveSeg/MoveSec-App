package com.moveseg.app.cadastro.Aluno.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoFormView {
    private AlunoId id;
    private String nome;
    private List<String> responsaveis;
    private Integer carteirinha;
    private String telefone;
    private String email;
    private String logradouro;
    private Integer numero;
    private String dataDeNascimento;
    private String genero;
    private String cpf;

    public static AlunoFormView of(Aluno aluno) {
        return AlunoFormView.builder()
                .id(aluno.id())
                .nome(aluno.nome())
                .responsaveis(aluno.responsaveis().stream().map(Responsavel::nome).collect(Collectors.toList()))
                .carteirinha(aluno.carteirinha().carteirinha())
                .telefone(aluno.telefone().telefone())
                .email(aluno.email().email())
                .logradouro(aluno.endereco().logradouro())
                .numero(aluno.endereco().numero())
                .dataDeNascimento(aluno.dataDeNascimento().toString())
                .genero(aluno.genero().toString())
                .cpf(aluno.cpf().cpf())
                .build();
    }
}
