package com.moveseg.app.cadastro.Monitor.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AtualizarMonitor {
    private MonitorId id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
}
