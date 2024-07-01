package com.moveseg.app.cadastro.Aluno.app.view;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoListView {
    private AlunoId id;
    private String nome;
    private String responsavel;
    private Integer carteirinha;
    private String telefone;
    private String email;
    private String logradouro;
    private Integer numero;
    private String dataDeNascimento;
    private String genero;
    private String cpf;

    public static AlunoListView of(Aluno aluno) {
        return AlunoListView.builder()
                .id(aluno.id())
                .nome(aluno.nome())
                .responsavel(aluno.responsaveis().get(0).nome())
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
