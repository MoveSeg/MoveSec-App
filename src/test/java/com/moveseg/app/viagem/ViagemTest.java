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
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.Viagem.ViagemBuilder;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class ViagemTest {

    private Aluno aluno;
    private List<Aluno> alunos;
    private RotaId rota;
    private MotoristaId motorista;
    private VeiculoId veiculo;
    private LocalDate data;
    private ViagemBuilder builder;

    private Aluno novoAluno;
    private List<Aluno> novosAlunos;
    private RotaId novaRota;
    private MotoristaId novoMotorista;
    private VeiculoId novoVeiculo;
    private LocalDate novaData;

    @BeforeEach
    void initializeBuilder() throws Exception {
        alunos = new ArrayList<Aluno>();
        alunos.add(aluno);
        motorista = DomainObjectId.randomId(MotoristaId.class);
        rota = DomainObjectId.randomId(RotaId.class);
        veiculo = DomainObjectId.randomId(VeiculoId.class);
        data = LocalDate.of(2000, 04, 30);
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
        novoMotorista = DomainObjectId.randomId(MotoristaId.class);
        novaRota = DomainObjectId.randomId(RotaId.class);
        novoVeiculo = DomainObjectId.randomId(VeiculoId.class);
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