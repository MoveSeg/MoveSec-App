package com.moveseg.app.cadastro.Aluno.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.Aluno.AlunoBuilder;
import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.sk.domain.Cpf;
import com.moveseg.app.cadastro.sk.domain.Genero;

public class AlunoTest {
    private String nome = "Nome";
    private Responsavel responsavel;
    private Carteirinha carteirinha;
    private Integer documento;
    private Telefone telefone;
    private Email email;
    private Endereco endereco;
    private Cpf cpf;
    private LocalDate dataDeNascimento;
    private AlunoBuilder builder;
    private List<Responsavel> responsaveis;

    private String novoNome = "Novo nome";
    private Responsavel novoResponsavel;
    private Carteirinha novaCarteirinha;
    private Telefone novoTelefone;
    private Email novoEmail;
    private Endereco novoEndereco;
    private Cpf novoCpf;
    private LocalDate novaDataDeNascimento;
    private List<Responsavel> novosResponsaveis;

    @BeforeEach
    void initializeBuilder() throws Exception {
        carteirinha = Carteirinha.of(22222);
        telefone = Telefone.of("415555555");
        email = Email.of("Exemplo@email.com");
        endereco = Endereco.of("Logradouro", 555);
        cpf = Cpf.of("55555");
        dataDeNascimento = LocalDate.of(1990, 3, 15);
        documento = 111111111;

        Responsavel responsavel = Responsavel.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.dataDeNascimento)
                .documento(this.documento)
                .build();

        novoResponsavel = Responsavel.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .documento(this.documento)
                .cpf(this.cpf)
                .nascimento(this.dataDeNascimento)
                .build();

        novaCarteirinha = Carteirinha.of(55555);
        novoTelefone = Telefone.of("4144444444");
        novoEmail = Email.of("SegundoExemplo@email.com");
        novoEndereco = Endereco.of("Novo Logradouro", 222);
        novoCpf = Cpf.of("666666");
        novaDataDeNascimento = LocalDate.of(2000, 1, 20);

        responsaveis = new ArrayList<Responsavel>();
        responsaveis.add(responsavel);

        novosResponsaveis = new ArrayList<Responsavel>();
        novosResponsaveis.add(novoResponsavel);

        this.builder = Aluno.builder()
                .carteirinha(this.carteirinha)
                .responsaveis(responsaveis)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .telefone(this.telefone)
                .cpf(this.cpf)
                .nome(this.nome)
                .email(this.email)
                .dataDeNascimento(this.dataDeNascimento);

    }

    @Test
    void dadoUmAlunoCompletoDeveCriar() throws Exception {
        Aluno aluno = this.builder.build();
        assertNotNull(aluno);
        assertNotNull(aluno.id());
        assertEquals(nome, aluno.nome());
        assertEquals(responsaveis, aluno.responsaveis());
        assertEquals(carteirinha, aluno.carteirinha());
        assertEquals(telefone, aluno.telefone());
        assertEquals(email, aluno.email());
        assertEquals(endereco, aluno.endereco());
        assertEquals(Genero.FEMININO, aluno.genero());
        assertEquals(cpf, aluno.cpf());
        assertEquals(dataDeNascimento, aluno.dataDeNascimento());
    }

    @Test
    void dadoUmAlunoSemNomeNaoDeveCriar() {

        builder.nome(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemResponavelNaoDeveCriar() {

        builder.responsaveis(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmCarteirinhaSemNaoDeveCriar() {

        builder.carteirinha(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemTelefoneNaoDeveCriar() {

        builder.telefone(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemEmailNaoDeveCriar() {

        builder.email(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemEnderecoNaoDeveCriar() {

        builder.endereco(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemGeneroNaoDeveCriar() {

        builder.genero(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemCpfeNaoDeveCriar() {

        builder.cpf(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmAlunoSemDataDeNascimentoNaoDeveCriar() {

        builder.dataDeNascimento(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {

        Aluno aluno = this.builder.build();
        aluno.atualizar()
                .nome(novoNome)
                .responsavel(novoResponsavel)
                .carteirinha(novaCarteirinha)
                .telefone(novoTelefone)
                .email(novoEmail)
                .endereco(novoEndereco)
                .genero(Genero.MASCULINO)
                .cpf(novoCpf)
                .dataDeNascimento(novaDataDeNascimento).aplicar();
        assertNotNull(aluno);
        assertEquals(novoNome, aluno.nome());
        assertEquals(novosResponsaveis, aluno.responsaveis());
        assertEquals(novaCarteirinha, aluno.carteirinha());
        assertEquals(novoTelefone, aluno.telefone());
        assertEquals(novoEmail, aluno.email());
        assertEquals(novoEndereco, aluno.endereco());
        assertEquals(Genero.MASCULINO, aluno.genero());
        assertEquals(novoCpf, aluno.cpf());
        assertEquals(novaDataDeNascimento, aluno.dataDeNascimento());
    }

    @Test
    void dadoNomeNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoResponsavelNuloDeveCriarVazio() {
        Aluno aluno = this.builder.build();

        aluno.atualizar()
                .nome(novoNome)
                .carteirinha(novaCarteirinha)
                .telefone(novoTelefone)
                .email(novoEmail)
                .endereco(novoEndereco)
                .genero(Genero.MASCULINO)
                .cpf(novoCpf)
                .dataDeNascimento(novaDataDeNascimento)
                .aplicar();

        assertEquals(novoNome, aluno.nome());
        assertEquals(new ArrayList<Responsavel>(), aluno.responsaveis());
        assertEquals(novaCarteirinha, aluno.carteirinha());
        assertEquals(novoTelefone, aluno.telefone());
        assertEquals(novoEmail, aluno.email());
        assertEquals(novoEndereco, aluno.endereco());
        assertEquals(Genero.MASCULINO, aluno.genero());
        assertEquals(novoCpf, aluno.cpf());
        assertEquals(novaDataDeNascimento, aluno.dataDeNascimento());
    }

    @Test
    void dadoCarteirinhaNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoTelefoneNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoEmailNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoEnderecoNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoGeneroNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoCpfNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .dataDeNascimento(novaDataDeNascimento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmasDataDeNascimentoNuloNaoDeveAtualizar() {
        Aluno aluno = this.builder.build();
        assertThrows(Exception.class, () -> {
            aluno.atualizar()
                    .nome(novoNome)
                    .responsavel(novoResponsavel)
                    .carteirinha(novaCarteirinha)
                    .telefone(novoTelefone)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .genero(Genero.MASCULINO)
                    .cpf(novoCpf)
                    .aplicar();

        });
    }

}