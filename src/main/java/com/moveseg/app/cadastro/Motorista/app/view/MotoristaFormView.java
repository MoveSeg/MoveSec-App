package com.moveseg.app.cadastro.Motorista.app.view;

import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MotoristaFormView {
    private MotoristaId id;
    private String nome;
    private String nascimento;
    private String email;
    private String telefone;
    private String logradouro;
    private Integer numero;
    private String genero;
    private String cpf;

    public static MotoristaFormView of(Motorista motorista) {
        return MotoristaFormView.builder()
            .id(motorista.id())
            .nome(motorista.nome())
            .nascimento(motorista.nascimento().toString())
            .email(motorista.email().email())
            .telefone(motorista.telefone().telefone())
            .logradouro(motorista.endereco().logradouro())
            .numero(motorista.endereco().numero())
            .genero(motorista.genero().toString())
            .cpf(motorista.cpf().cpf())
            .build();
        }

}
