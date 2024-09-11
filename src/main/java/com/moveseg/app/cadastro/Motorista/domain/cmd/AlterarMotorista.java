package com.moveseg.app.cadastro.Motorista.domain.cmd;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlterarMotorista {
    private MotoristaId id;
    private String nome;
    private LocalDate nascimento;
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
}
