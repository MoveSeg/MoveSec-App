package com.moveseg.app.cadastro.Motorista.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Motorista.domain.Motorista.MotoristaBuilder;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

public class MotoristaTest {
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    private Genero genero;
    private Cpf cpf;
    private String nome = "Luna";
    private LocalDate nascimento = LocalDate.of(2006, 02, 04);

    public String novoNome;
    public Integer novoDocumento;
    public LocalDate novoNascimento;
    public Email novoEmail;
    public Telefone novoTelefone;
    public Endereco novoEndereco;
    public Genero novoGenero;
    public Cpf novoCpf;
    private MotoristaBuilder builder;

    @BeforeEach
    void initializeBuilder() throws Exception {
        genero = Genero.FEMININO;
        email = Email.of("Exemplo@exemplo.com");
        telefone = Telefone.of("41999999999");
        endereco = Endereco.of("Rua", 44);
        cpf = Cpf.of("23456789002");
        this.builder = Motorista.builder()
                .nome(nome)
                .nascimento(nascimento)
                .email(email)
                .telefone(telefone)
                .endereco(endereco)
                .genero(genero)
                .cpf(cpf);
    }

    @Test
    void dadoUmMotoristaCompletoDeveCriar() throws Exception {

        Motorista motorista = builder
                .build();

        assertNotNull(motorista);
        assertNotNull(motorista.id());
        assertEquals(email, motorista.email());
        assertEquals(telefone, motorista.telefone());
        assertEquals(endereco, motorista.endereco());
        assertEquals(nascimento, motorista.nascimento());
        assertEquals(nome, motorista.nome());
        assertEquals(genero, motorista.genero());
        assertEquals(cpf, motorista.cpf());
    }

    @Test
    void dadoUmMotoristaSemNomeNaoDeveCriar() {

        builder.nome(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemNascimentoNaoDeveCriar() {
        builder.nascimento(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemEmailNaoDeveCriar() {
        builder.email(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemTelefoneNaoDeveCriar() {
        builder.telefone(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemEnderecoNaoDeveCriar() {
        builder.endereco(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemGeneroNaoDeveCriar() {
        builder.genero(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMotoristaSemCpfNaoDeveCriar() {
        builder.cpf(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoNovosDadosDeveAtualizarOMotoristaEManterNaoNulo() throws Exception {
        Email novoEmail = Email.of("Luna@aaaa.com");
        Genero novoGenero = Genero.FEMININO;
        Cpf novoCpf = Cpf.of("23456789332");
        Telefone novoTelefone = Telefone.of("41999989999");
        Endereco novoEndereco = Endereco.of("Rua AAAA ", 44);
        String novoNome = "Novo nome";
        LocalDate novoNascimento = LocalDate.of(2008, 04, 06);
        Motorista motorista = this.builder.build();
        motorista.atualizar()
                .nome(novoNome)
                .cpf(novoCpf)
                .genero(novoGenero)
                .nascimento(novoNascimento)
                .email(novoEmail)
                .telefone(novoTelefone)
                .endereco(novoEndereco).aplicar();

        assertNotNull(motorista.id());
        assertEquals(novoNome, motorista.nome());
        assertEquals(novoCpf, motorista.cpf());
        assertEquals(novoGenero, motorista.genero());
        assertEquals(novoNascimento, motorista.nascimento());
        assertEquals(novoEmail, motorista.email());
        assertEquals(novoTelefone, motorista.telefone());
        assertEquals(novoEndereco, motorista.endereco());
    }

    @Test
    void dadoUmNomeNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }
    @Test
    void dadoUmCpfNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {    
            motorista.atualizar()

                    .nome(novoNome)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmGeneroNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmNascimentoNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmEmailNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmTelefoneNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }

    @Test
    void dadoUmEnderecoNuloNaoDeveAtualizar() {
        Motorista motorista = this.builder.build();
        assertThrows(Exception.class, () -> {
            motorista.atualizar()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .nascimento(novoNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .documento(novoDocumento)
                    .aplicar();

        });
    }
}