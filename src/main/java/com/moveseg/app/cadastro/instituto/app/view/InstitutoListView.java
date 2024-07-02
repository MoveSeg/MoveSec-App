package com.moveseg.app.cadastro.Instituto.app.view;

import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;
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
    private String responsavel;
    private String telefone;
    private String email;

    public static InstitutoListView of(Instituto Instituto) {
        return InstitutoListView.builder()
                .id(Instituto.id())
                .nome(Instituto.nome())
                .responsavel(Instituto.responsaveis().get(0).nome())
                .telefone(Instituto.telefone().numero())
                .email(Instituto.email().email())
                .logradouro(Instituto.endereco().logradouro())
                .numero(Instituto.endereco().numero())
                .build();
    }

}
