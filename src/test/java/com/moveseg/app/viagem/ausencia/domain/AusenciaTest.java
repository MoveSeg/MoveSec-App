package com.moveseg.app.viagem.ausencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.Aluno.AlunoBuilder;
import com.moveseg.app.cadastro.Aluno.domain.Carteirinha;
import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
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

public final class AusenciaTest {
    private Aluno aluno;
    private AlunoBuilder alunoBuilder;
    private Carteirinha carteirinha;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private List<Responsavel> responsaveis;
    private Rota rota;
    private Motorista motorista;
    private Veiculo veiculo;
    private LocalDate dataViagem = LocalDate.of(2000, 04, 30);
    private LocalDate data;
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
    void ausenciaCompletoDeveSalvar() throws Exception {
        enderecos.add(endereco);
        numeroRota = Numero.of("317R");
        rota = Rota.of(numeroRota, enderecos);
        data = LocalDate.of(2000, 04, 30);
        telefone = Telefone.of("415555555");
        email = Email.of("Exemplo@email.com");
        endereco = Endereco.of("Logradouro", 555);
        cpf = Cpf.of("55555");
        carteirinha = Carteirinha.of(22222);

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
        Responsavel responsavel = Responsavel.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.data)
                .build();
        responsaveis = new ArrayList<Responsavel>();
        responsaveis.add(responsavel);

        alunoBuilder = Aluno.builder()
                .carteirinha(this.carteirinha)
                .responsaveis(responsaveis)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .telefone(this.telefone)
                .cpf(this.cpf)
                .nome(this.nome)
                .email(this.email)
                .dataDeNascimento(this.data);
        aluno = alunoBuilder.build();
        this.alunos.add(aluno);

        viagem = Viagem.builder()
                .alunos(alunos)
                .motorista(motorista)
                .rota(rota)
                .veiculo(veiculo)
                .data(dataViagem)
                .build();
        data = LocalDate.of(2000, 1, 20);

        Ausencia ausencia = Ausencia.from(viagem, "Doente", aluno);
        assertNotNull(ausencia);
        assertNotNull(ausencia.id());
        assertNotNull(ausencia.data());
        assertNotNull(ausencia.viagem());
        assertEquals("Doente", ausencia.motivo());
    }

    @Test
    void dadoUmaAusenciaSemMotivoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(viagem, null, aluno);
        });
    }

    @Test
    void dadoUmaAusenciaSemViagemNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, "Motivo", aluno);
        });
    }

    @Test
    void dadoUmaAusenciaSemAlunoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(viagem, "Motivo", null);
        });
    }

    @Test
    void dadoUmaAusenciaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ausencia.from(null, null, null);
        });
    }
}