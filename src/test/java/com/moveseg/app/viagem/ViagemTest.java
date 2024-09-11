package com.moveseg.app.viagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
import com.moveseg.app.viagem.domain.Viagem.ViagemBuilder;

public class ViagemTest {

    private Aluno aluno;
    private List<Aluno> alunos;
    private Rota rota;
    private Motorista motorista;
    private Veiculo veiculo;
    private LocalDate data;
    private String nome = "Nome";
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Cpf cpf;
    private Numero numeroRota;
    private List<Endereco> enderecos;
    private Placa placa;
    private Chassi chassi;
    private Renavam renavam;
    private Integer anoModelo;
    private String marca;
    private String modelo;
    private String corPredominante;
    private Integer capacidadeDePassageiros;
    private ViagemBuilder builder;

    private Aluno novoAluno;
    private List<Aluno> novosAlunos;
    private Rota novaRota;
    private Motorista novoMotorista;
    private Veiculo novoVeiculo;
    private LocalDate novaData;
    private Endereco novoEndereco;
    private Integer frota;
    private List<Endereco> novosEnderecos;

    @BeforeEach
    void initializeBuilder() throws Exception {
        alunos = new ArrayList<Aluno>();
        alunos.add(aluno);
        data = LocalDate.of(2000, 04, 30);
        telefone = Telefone.of("415555555");
        email = Email.of("Exemplo@email.com");
        endereco = Endereco.of("Logradouro", 555);
        cpf = Cpf.of("55555");

        numeroRota = Numero.of("317R");
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);

        novosEnderecos = new ArrayList<Endereco>();
        novosEnderecos.add(novoEndereco);

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

        novoMotorista = Motorista.builder()
        .nome(this.nome)
        .telefone(this.telefone)
        .email(this.email)
        .endereco(this.endereco)
        .genero(Genero.FEMININO)
        .cpf(this.cpf)
        .nascimento(this.data)
        .build();


        rota = Rota.of(numeroRota, enderecos);
        novaRota = Rota.of(numeroRota, enderecos);

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
        novoVeiculo = veiculoBuilder.build();

        this.builder = Viagem.builder()
                .alunos(alunos)
                .motorista(motorista)
                .rota(rota)
                .veiculo(veiculo)
                .data(data);
    }

    @Test
    void dadoViagemCompletaDeveCriar() {
        Viagem viagem = this.builder.build();
        assertNotNull(viagem);
        assertEquals(alunos, viagem.alunos());
        assertEquals(motorista, viagem.motorista());
        assertEquals(rota, viagem.rota());
        assertEquals(data, viagem.data());
    }

    @Test
    void dadoUmaViagemSemMotoristaNaoDeveCriar() {

        builder.motorista(null);
        assertThrows(Exception.class, () -> builder.build());

    }

    @Test
    void dadoUmaViagemSemRotaNaoDeveCriar() {

        builder.motorista(null);
        assertThrows(Exception.class, () -> builder.build());

    }

    @Test
    void dadoUmaViagemSemDataNaoDeveCriar() {

        builder.data(null);
        assertThrows(Exception.class, () -> builder.build());

    }

    @Test
    void dadoUmaViagemSemVeiculoNaoDeveCriar() {

        builder.veiculo(null);
        assertThrows(Exception.class, () -> builder.build());

    }

    @Test
    void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {
        novosAlunos = new ArrayList<Aluno>();
        novosAlunos.add(novoAluno);

        novaData = LocalDate.of(2017, 04, 20);
        Viagem viagem = this.builder.build();
        viagem.atualizar()
                .alunos(novosAlunos)
                .motorista(novoMotorista)
                .rota(novaRota)
                .veiculo(novoVeiculo)
                .data(novaData)
                .aplicar();
        assertNotNull(viagem.id());
        assertEquals(novosAlunos, viagem.alunos());
        assertEquals(novoMotorista, viagem.motorista());
        assertEquals(novaRota, viagem.rota());
        assertEquals(novoVeiculo, viagem.veiculo());
        assertEquals(novaData, viagem.data());
    }

    @Test
    void dadoUmAlunoNuloNaoDeveAtualizar() {
        Viagem viagem = this.builder.build();
        assertThrows(Exception.class, () -> {
            viagem.atualizar()
                    .motorista(novoMotorista)
                    .rota(novaRota)
                    .veiculo(novoVeiculo)
                    .data(novaData)
                    .aplicar();
        });

    }

    @Test
    void dadoUmMotoristaNuloNaoDeveAtualizar() {
        Viagem viagem = this.builder.build();
        assertThrows(Exception.class, () -> {
            viagem.atualizar()
                    .alunos(novosAlunos)
                    .rota(novaRota)
                    .veiculo(novoVeiculo)
                    .data(novaData)
                    .aplicar();
        });

    }

    @Test
    void dadoUmaRotaNulaNaoDeveAtualizar() {
        Viagem viagem = this.builder.build();
        assertThrows(Exception.class, () -> {
            viagem.atualizar()
                    .alunos(novosAlunos)
                    .rota(novaRota)
                    .motorista(novoMotorista)
                    .veiculo(novoVeiculo)
                    .aplicar();
        });
    }

    @Test
    void dadoUmVeiculoNuloNaoDeveAtualizar() {
        Viagem viagem = this.builder.build();
        assertThrows(Exception.class, () -> {
            viagem.atualizar()
                    .alunos(novosAlunos)
                    .rota(novaRota)
                    .veiculo(novoVeiculo)
                    .motorista(novoMotorista)
                    .data(novaData)
                    .aplicar();
        });

    }

}