package com.moveseg.app.cadastro.Instituto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Instituto.InstitutoBuilder;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

public class InstitutoTest {

    private String nome = "Nome";
    private Endereco endereco;
    private Responsavel responsavel;
    private Telefone telefone;
    private Email email;
    private Cpf cpf;
    private LocalDate dataDeNascimento;
    private InstitutoBuilder builder;
    private List<Responsavel> responsaveis;

    private String novoNome;
    private Endereco novoEndereco;
    private Responsavel novoResponsavel;
    private Telefone novoTelefone;
    private Email novoEmail;
    private List<Responsavel> novosResponsaveis;

    @BeforeEach
    void initializeBuilder() throws Exception {
        endereco = Endereco.of("logradouro", 555);
        telefone = Telefone.of("1123456 - 7890");
        email = Email.of("Exemplo@gmail.com");
        cpf = Cpf.of("55555");
        dataDeNascimento = LocalDate.of(1990, 3, 15);
        responsavel = Responsavel.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.dataDeNascimento)
                .build();
        novoResponsavel = Responsavel.builder()
                .nome(this.nome)
                .telefone(this.telefone)
                .email(this.email)
                .endereco(this.endereco)
                .genero(Genero.FEMININO)
                .cpf(this.cpf)
                .nascimento(this.dataDeNascimento)
                .build();

        responsaveis = new ArrayList<Responsavel>();
        responsaveis.add(responsavel);

        novoNome = "Novo nome";
        novoEndereco = Endereco.of("Novo endereco", 9999);
        novoTelefone = Telefone.of(("415555555"));
        novoEmail = Email.of("Exemplo2@gmail.com");
        this.builder = Instituto.builder()
                .responsaveis(responsaveis)
                .nome(nome)
                .email(email)
                .telefone(telefone)
                .endereco(endereco);
    }

    @Test
    void dadoInstitutoCompletoDeveCriar() throws Exception {
        Instituto instituto = this.builder.build();
        assertNotNull(instituto);
        assertEquals(this.nome, instituto.nome());
        assertEquals(this.endereco, instituto.endereco());
        assertEquals(this.responsaveis, instituto.responsaveis());
        assertEquals(this.telefone, instituto.telefone());
        assertEquals(this.email, instituto.email());
    }

    @Test
    void dadoUmInstitutoSemResponsavelNaoDeveCriarVazio() {
        assertThrows(Exception.class, () -> {
            Instituto.builder()
                    .responsaveis(null)
                    .nome(nome)
                    .email(email)
                    .telefone(telefone)
                    .endereco(endereco).build();
        });
    }

    @Test
    void dadoUmInstitutoSemNomeNaoDeveCriar() {
        this.builder.nome(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }

    @Test
    void dadoUmInstitutoSemEnderecoNaoDeveCriar() {
        this.builder.endereco(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }

    @Test
    void dadoInstitutoUmSemTelefoneNaoDeveCriar() {
        this.builder.telefone(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }

    @Test
    void dadoInstitutoUmSemEmailNaoDeveCriar() {
        this.builder.email(null);
        assertThrows(Exception.class, () -> {
            this.builder.build();
        });
    }

    @Test
    void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {
        novosResponsaveis = new ArrayList<Responsavel>();
        novosResponsaveis.add(novoResponsavel);
        Instituto instituto = this.builder.build();
        instituto.atualizar()
                .nome(novoNome)
                .endereco(novoEndereco)
                .responsaveis(novosResponsaveis)
                .telefone(novoTelefone)
                .email(novoEmail)
                .aplicar();
        assertNotNull(instituto);
        assertNotNull(instituto.id());
        assertEquals(novoNome, instituto.nome());
        assertEquals(novoEndereco, instituto.endereco());
        assertEquals(novosResponsaveis, instituto.responsaveis());
        assertEquals(novoTelefone, instituto.telefone());
        assertEquals(novoEmail, instituto.email());
    }

    @Test
    void dadoNomeNuloNaoDeveAtualizar() throws Exception {
        Instituto instituto = this.builder.build();
        assertThrows(Exception.class, () -> {
            instituto.atualizar()
                    .endereco(novoEndereco)
                    .responsaveis(novosResponsaveis)
                    .telefone(novoTelefone)
                    .email(novoEmail).aplicar();
        });
    }

    @Test
    void dadoEnderecoNuloNaoDeveAtualizar() {
        Instituto instituto = this.builder.build();
        assertThrows(Exception.class, () -> {
            instituto.atualizar()
                    .nome(novoNome)
                    .responsaveis(novosResponsaveis)
                    .telefone(novoTelefone)
                    .email(novoEmail).aplicar();
        });
    }

    @Test
    void dadoTelefonelNuloNaoDeveAtualizar() {
        Instituto instituto = this.builder.build();
        assertThrows(Exception.class, () -> {
            instituto.atualizar()
                    .nome(novoNome)
                    .endereco(novoEndereco)
                    .responsaveis(novosResponsaveis)
                    .email(novoEmail).aplicar();
        });
    }

    @Test
    void dadoEmailNuloNaoDeveAtualizar() {
        Instituto instituto = this.builder.build();
        assertThrows(Exception.class, () -> {
            instituto.atualizar()
                    .nome(novoNome)
                    .endereco(novoEndereco)
                    .responsaveis(novosResponsaveis)
                    .telefone(novoTelefone)
                    .aplicar();
        });
    }
}
