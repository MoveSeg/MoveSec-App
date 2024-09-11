package com.moveseg.app.cadastro.Motorista.domain.cmd;

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
public class CriarMotorista {
    private Email email;
    private Endereco endereco;
    private Telefone telefone;
    private Genero genero;
    private Cpf cpf;
    private String nome;
    private LocalDate nascimento;
}
