package com.moveseg.app.cadastro.Instituto.app.view;

import java.util.List;
import java.util.stream.Collectors;

import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstitutoListView {
    private InstitutoId id;
    private String nome;
    private String logradouro;
    private Integer numero;
    private List<String> responsaveis;
    private String telefone;
    private String email;

    public static InstitutoListView of(Instituto instituto) {
        return InstitutoListView.builder()
                .id(instituto.id())
                .nome(instituto.nome())
                .responsaveis(instituto.responsaveis().stream().map(Responsavel::nome).collect(Collectors.toList()))
                .telefone(instituto.telefone().telefone())
                .email(instituto.email().email())
                .logradouro(instituto.endereco().logradouro())
                .numero(instituto.endereco().numero())
                .build();
    }

}
