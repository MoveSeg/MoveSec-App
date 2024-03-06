package com.moveseg.app.cadastro.responsavel.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.responsavel.domain.Cpf;
import com.moveseg.app.cadastro.responsavel.domain.Genero;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel.ResponsavelBuilder;

class ResponsavelTest {

    public String novoNome;
    public Integer novoDocumento;
    public LocalDate novoNascimento;
    public Email novoEmail;
    public Telefone novoTelefone;
    public Endereco novoEndereco;
    public Genero novoGenero;
    public Cpf novoCpf;

    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
    private String nome = "Luna";
    private Integer documento = 1222342440;
    private LocalDate nascimento = LocalDate.of(2006, 02, 04);
    private ResponsavelBuilder builder;

    @BeforeEach
    void initializeBuilder() throws Exception {
        genero = Genero.of("feminino");
        email = Email.of("alana@aaaa.com");
        telefone = Telefone.of("41987876666");
        endereco = Endereco.of("Rua", 44);
        cpf = Cpf.of("23456789002");
        this.builder = Responsavel.builder()
                .nome(nome)
                .documento(documento)
                .nascimento(nascimento)
                .email(email)
                .telefone(telefone)
                .endereco(endereco)
                .genero(genero)
                .cpf(cpf);
    }

    @Test
    void dadoUmResponsavelCompletoDeveCriar() throws Exception {

        Responsavel responsavel = builder
                .build();

        assertNotNull(responsavel);
        assertNotNull(responsavel.id());
        assertEquals(email, responsavel.email());
        assertEquals(documento, responsavel.documento());
        assertEquals(telefone, responsavel.telefone());
        assertEquals(endereco, responsavel.endereco());
        assertEquals(nascimento, responsavel.nascimento());
        assertEquals(nome, responsavel.nome());
        assertEquals(genero, responsavel.genero());
        assertEquals(cpf, responsavel.cpf());
    }

    @Test
    void dadoUmResponsavelSemNomeNaoDeveCriar() {

        builder.nome(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemNascimentoNaoDeveCriar() {
        builder.nascimento(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemEmailNaoDeveCriar() {
        builder.email(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemTelefoneNaoDeveCriar() {
        builder.telefone(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemEnderecoNaoDeveCriar() {
        builder.endereco(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemGeneroNaoDeveCriar() {
        builder.genero(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemCpfNaoDeveCriar() {
        builder.cpf(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmResponsavelSemDocumentoNaoDeveCriar() {
        builder.documento(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoNovosDadosDoNomeDeveAtualizarOResponsavelEManterNaoNulo() throws Exception {
        Email novoEmail = Email.of("Luna@aaaa.com");
        Genero novoGenero = Genero.of("Luna@aaaa");
        Cpf novoCpf = Cpf.of("Luna@aaaa");
        Telefone novoTelefone = Telefone.of("41987844666");
        Endereco novoEndereco = Endereco.of("Rua AAAA ", 44);
        String novoNome = "Novo nome";
        LocalDate novoNascimento = LocalDate.of(2008, 04, 06);
        Integer novoDocumento = 676767676;

        Responsavel responsavel = this.builder.build();
        responsavel.update()
                .nome(novoNome)
                .cpf(novoCpf)
                .genero(novoGenero)
                .nascimento(novoNascimento)
                .email(novoEmail)
                .documento(novoDocumento)
                .telefone(novoTelefone)
                .endereco(novoEndereco).apply();

        assertNotNull(responsavel.id());
        assertEquals(novoNome, responsavel.nome());
        assertEquals(novoCpf, responsavel.cpf());
        assertEquals(novoGenero, responsavel.genero());
        assertEquals(novoNascimento, responsavel.nascimento());
        assertEquals(novoEmail, responsavel.email());
        assertEquals(novoTelefone, responsavel.telefone());
        assertEquals(novoEndereco, responsavel.endereco());
        assertEquals(novoDocumento, responsavel.documento());
    }
    @Test
    void dadoUmNomeNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmCpfNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {    
            responsavel.update()

                    .nome(novoNome)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmGeneroNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmNascimentoNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmEmailNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmTelefoneNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmEnderecoNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .documento(novoDocumento)
                    .apply();

        });
    }

    @Test
    void dadoUmDocumentoNuloNaoDeveAtualizar() {
        Responsavel responsavel = this.builder.build();
        assertThrows(Exception.class, () -> {
            responsavel.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }
    

} 