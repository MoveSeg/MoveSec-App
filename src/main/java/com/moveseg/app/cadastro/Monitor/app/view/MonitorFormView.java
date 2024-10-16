package com.moveseg.app.cadastro.Monitor.app.view;

import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorFormView {
    private MonitorId id;
    private String nome;
    private String dataDeNascimento;
    private String email;
    private String telefone;
    private String logradouro;
    private Integer numero;
    private String genero;
    private String cpf;

    public static MonitorFormView of(Monitor monitor) {
        return MonitorFormView.builder()
            .id(monitor.id())
            .nome(monitor.nome())
            .dataDeNascimento(monitor.dataDeNascimento().toString())
            .email(monitor.email().email())
            .telefone(monitor.telefone().telefone())
            .logradouro(monitor.endereco().logradouro())
            .numero(monitor.endereco().numero())
            .genero(monitor.genero().toString())
            .cpf(monitor.cpf().cpf())
            .build();
        }

}
