package com.moveseg.app.cadastro.Monitor.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarMonitor {
    public String nome;
    public LocalDate dataDeNascimento;
    public Telefone telefone;
    public Email email;
    public Endereco endereco;
    public Genero genero;
    public Cpf cpf;
}