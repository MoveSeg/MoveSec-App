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
    public Email email;
    public Endereco endereco;
    public Telefone telefone;
    public Genero genero;
    public Cpf cpf;
    public String nome;
    public LocalDate nascimento;
}
