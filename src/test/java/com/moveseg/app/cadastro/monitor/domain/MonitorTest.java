package com.moveseg.app.cadastro.monitor.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Email;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.Instituto.domain.Telefone;
import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.Monitor.MonitorBuilder;
import com.moveseg.app.cadastro.veiculo.sk.domain.Cpf;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;

class MonitorTest {

    public String novoNome;
    public LocalDate novaDataDeNascimento;
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
    private String nome = "Luca";
    private LocalDate dataDeNascimento = LocalDate.of(2008, 01, 05);
    private MonitorBuilder builder;

    @BeforeEach
    void initializeBuilder() throws Exception {
        genero = Genero.FEMININO;
        email = Email.of("elena@aaaa.com");
        telefone = Telefone.of("41966668888");
        endereco = Endereco.of("Rua", 66);
        cpf = Cpf.of("118");
        this.builder = Monitor.builder()
                .nome(nome)
                .dataDeNascimento(dataDeNascimento)
                .email(email)
                .telefone(telefone)
                .endereco(endereco)
                .genero(genero)
                .cpf(cpf);
    }

    @Test
    void dadoUmMonitorCompletoDeveCriar() throws Exception {

        Monitor monitor = builder
                .build();

        assertNotNull(monitor);
        assertNotNull(monitor.id());
        assertEquals(email, monitor.email());
        assertEquals(telefone, monitor.telefone());
        assertEquals(endereco, monitor.endereco());
        assertEquals(dataDeNascimento, monitor.dataDeNascimento());
        assertEquals(nome, monitor.nome());
        assertEquals(genero, monitor.genero());
        assertEquals(cpf, monitor.cpf());
    }

    @Test
    void dadoUmMonitorSemNomeNaoDeveCriar() {

        builder.nome(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemNascimentoNaoDeveCriar() {
        builder.dataDeNascimento(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemEmailNaoDeveCriar() {
        builder.email(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemTelefoneNaoDeveCriar() {
        builder.telefone(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemEnderecoNaoDeveCriar() {
        builder.endereco(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemGeneroNaoDeveCriar() {
        builder.genero(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmMonitorSemCpfNaoDeveCriar() {
        builder.cpf(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoNovosDadosDoNomeDeveAtualizarOMonitorEManterNaoNulo() throws Exception {
        Email novoEmail = Email.of("Luca@aaaa.com");
        Genero novoGenero = Genero.MASCULINO;
        Cpf novoCpf = Cpf.of("2222222222");
        Telefone novoTelefone = Telefone.of("41987844666");
        Endereco novoEndereco = Endereco.of("Rua AAAA ", 44);
        String novoNome = "Novo nome";
        LocalDate novaDataDeNascimento = LocalDate.of(2008, 01, 05);

        Monitor monitor = this.builder.build();
        monitor.update()
                .nome(novoNome)
                .cpf(novoCpf)
                .genero(novoGenero)
                .dataDeNascimento(novaDataDeNascimento)
                .email(novoEmail)
                .telefone(novoTelefone)
                .endereco(novoEndereco).apply();

        assertNotNull(monitor.id());
        assertEquals(novoNome, monitor.nome());
        assertEquals(novoCpf, monitor.cpf());
        assertEquals(novoGenero, monitor.genero());
        assertEquals(novaDataDeNascimento, monitor.dataDeNascimento());
        assertEquals(novoEmail, monitor.email());
        assertEquals(novoTelefone, monitor.telefone());
        assertEquals(novoEndereco, monitor.endereco());
    }

    @Test
    void dadoUmNomeNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .dataDeNascimento(novaDataDeNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmCpfNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .genero(novoGenero)
                    .dataDeNascimento(novaDataDeNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmGeneroNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .dataDeNascimento(novaDataDeNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmaDataDeNascimentoNulaNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmEmailNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .dataDeNascimento(novaDataDeNascimento)
                    .telefone(novoTelefone)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmTelefoneNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .dataDeNascimento(novaDataDeNascimento)
                    .email(novoEmail)
                    .endereco(novoEndereco)
                    .apply();

        });
    }

    @Test
    void dadoUmEnderecoNuloNaoDeveAtualizar() {
        Monitor monitor = this.builder.build();
        assertThrows(Exception.class, () -> {
            monitor.update()

                    .nome(novoNome)
                    .cpf(novoCpf)
                    .genero(novoGenero)
                    .dataDeNascimento(novaDataDeNascimento)
                    .email(novoEmail)
                    .telefone(novoTelefone)
                    .apply();

        });
    }

}
