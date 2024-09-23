package com.moveseg.app.viagem.Programacao.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.veiculo.domain.Chassi;
import com.moveseg.app.cadastro.veiculo.domain.Placa;
import com.moveseg.app.cadastro.veiculo.domain.Renavam;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo.VeiculoBuilder;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.domain.Viagem;

public class ProgramacaoTest {
    private Aluno aluno;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private Rota rota;
    private Motorista motorista;
    private Veiculo veiculo;
    private LocalDate data;
    private LocalDateTime dataProgramacao;
    private Viagem viagem;
    private Endereco endereco;
    private Numero numeroRota;
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    private String nome = "Nome";
    private Telefone telefone;
    private Email email;
    private Cpf cpf;

    private Placa placa;
    private Chassi chassi;
    private Renavam renavam;
    private Integer anoModelo;
    private String marca;
    private String modelo;
    private Integer frota;
    private String corPredominante;
    private Integer capacidadeDePassageiros;

    @Test
    void programacaoCompletoDeveSalvar() throws Exception {
    enderecos.add(endereco);
    numeroRota = Numero.of("317R");
    rota = Rota.of(numeroRota, enderecos);
    this.alunos.add(aluno);
    data = LocalDate.of(2000, 04, 30);
        telefone = Telefone.of("415555555");
        email = Email.of("Exemplo@email.com");
        endereco = Endereco.of("Logradouro", 555);
        cpf = Cpf.of("55555");

        numeroRota = Numero.of("317R");
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);

        placa = Placa.of("ASDASD");
        chassi = Chassi.of("ASDASD");
        renavam = Renavam.of("asdasd");
        frota = 128;
        anoModelo = 2012;
        marca = "Marca";
        modelo = "Modelo";
        corPredominante = "Azul";
        capacidadeDePassageiros = 8;

        motorista = Motorista.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.data)
                .build();


        VeiculoBuilder veiculoBuilder = Veiculo.builder()
        .placa(placa)
        .numeroDaFrota(frota)
        .chassi(chassi)
        .renavam(renavam)
        .anoModelo(anoModelo)
        .marca(marca)
        .modelo(modelo)
        .corPredominante(corPredominante)
        .capacidadeDePassageiros(capacidadeDePassageiros);
        veiculo = veiculoBuilder.build();
        viagem = Viagem.builder()
        .alunos(alunos)
        .motorista(motorista)
        .rota(rota)
        .veiculo(veiculo)
        .data(data)
        .build();
        dataProgramacao = LocalDateTime.of(2024, 03, 15, 14, 30);
        Programacao programacao = Programacao.from(viagem, dataProgramacao);
        assertNotNull(programacao);
        assertNotNull(programacao.id());
        assertNotNull(data);
        assertEquals(viagem, programacao.viagem());
    }

    @Test
    void dadoUmaProgramacaoSemDataNaoDeveCriar() throws Exception {
        enderecos.add(endereco);
    numeroRota = Numero.of("317R");
    rota = Rota.of(numeroRota, enderecos);
    this.alunos.add(aluno);
    data = LocalDate.of(2000, 04, 30);
        telefone = Telefone.of("415555555");
        email = Email.of("Exemplo@email.com");
        endereco = Endereco.of("Logradouro", 555);
        cpf = Cpf.of("55555");

        numeroRota = Numero.of("317R");
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);

        placa = Placa.of("ASDASD");
        chassi = Chassi.of("ASDASD");
        renavam = Renavam.of("asdasd");
        frota = 128;
        anoModelo = 2012;
        marca = "Marca";
        modelo = "Modelo";
        corPredominante = "Azul";
        capacidadeDePassageiros = 8;

        motorista = Motorista.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.data)
                .build();


        VeiculoBuilder veiculoBuilder = Veiculo.builder()
        .placa(placa)
        .numeroDaFrota(frota)
        .chassi(chassi)
        .renavam(renavam)
        .anoModelo(anoModelo)
        .marca(marca)
        .modelo(modelo)
        .corPredominante(corPredominante)
        .capacidadeDePassageiros(capacidadeDePassageiros);
        veiculo = veiculoBuilder.build();
        viagem = Viagem.builder()
        .alunos(alunos)
        .motorista(motorista)
        .rota(rota)
        .veiculo(veiculo)
        .data(data)
        .build();
        
        this.alunos.add(aluno);
        viagem = Viagem.builder()
        .alunos(alunos)
        .motorista(motorista)
        .rota(rota)
        .veiculo(veiculo)
        .data(data)
        .build();
        assertThrows(Exception.class, () -> {
            Programacao.from(viagem, null);
        });
    }

    @Test
    void dadoUmaProgramacaoSemViagemNaoDeveCriar() {
        dataProgramacao = LocalDateTime.of(2014, 07, 10, 10, 15);
        assertThrows(Exception.class, () -> {
            Programacao.from(null, dataProgramacao);
        });
    }

    @Test
    void dadoUmaProgramacaoIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Programacao.from(null, null);
        });
    }
}
