package com.moveseg.app.viagem.ocorrencia.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
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
import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class OcorrenciaTest {

    private String motivo = "Dormiu demais";
    private Aluno aluno;
    private List<Aluno> alunos = new ArrayList<Aluno>();
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
    void dadoUmaOcorrenciaCompletaDeveCriar() throws Exception {
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
                .data(dataViagem)
                .build();
        data = LocalDate.of(2000, 1, 20);
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        Ocorrencia ocorrencia = Ocorrencia.of(motivo, viagem, aluno);

        assertNotNull(ocorrencia);
        assertNotNull(ocorrencia.id());
        assertNotNull(ocorrencia.viagem());
        assertNotNull(ocorrencia.aluno());
        assertEquals(motivo, ocorrencia.motivo());
    }

    @Test
    void dadoUmaOcorrenciaSemViagemNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
            Ocorrencia.of("Dormi demais", null, aluno);
        });
    }

    @Test
    void dadoUmaOcorrenciaSemMotivoNaoDeveCriar() {
        AlunoId aluno = DomainObjectId.randomId(AlunoId.class);
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, viagem, aluno);
        });
    }

    @Test
    void dadoUmaOcorrenciaSemAlunoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of("Dormi demais", viagem, null);
        });
    }

    @Test
    void dadoUmaOcorrenciaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Ocorrencia.of(null, null, null);
        });
    }
}
