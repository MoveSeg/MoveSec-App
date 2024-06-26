package com.moveseg.app.viagem.Programacao.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cadastro.veiculo.sk.domain.Genero;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.Viagem.ViagemBuilder;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class ProgramacaoTest {
    private Aluno aluno;
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private RotaId rota = DomainObjectId.randomId(RotaId.class);
    private MotoristaId motorista = DomainObjectId.randomId(MotoristaId.class);
    private VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
    private LocalDate dataViagem = LocalDate.of(2000, 04, 30);
    private LocalDate data;
    private Viagem viagem;

    @Test
    void agendaCompletoDeveSalvar() {
    this.alunos.add(aluno);
    viagem = Viagem.builder()
    .alunos(alunos)
    .motorista(motorista)
    .rota(rota)
    .veiculo(veiculo)
    .data(dataViagem)
    .build();
        data = LocalDate.of(2000, 1, 20);
        Programacao programacao = Programacao.from(viagem, data);
        assertNotNull(programacao);
        assertNotNull(programacao.id());
        assertNotNull(data);
        assertEquals(viagem, programacao.viagem());
    }

    @Test
    void dadoUmaAgendaSemDataNaoDeveCriar() {
        this.alunos.add(aluno);
        viagem = Viagem.builder()
        .alunos(alunos)
        .motorista(motorista)
        .rota(rota)
        .veiculo(veiculo)
        .data(dataViagem)
        .build();
        assertThrows(Exception.class, () -> {
            Programacao.from(viagem, null);
        });
    }

    @Test
    void dadoUmaAgendaSemViagemNaoDeveCriar() {
        data = LocalDate.of(2014, 07, 10);
        assertThrows(Exception.class, () -> {
            Programacao.from(null, data);
        });
    }

    @Test
    void dadoUmaAgendaIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Programacao.from(null, null);
        });
    }
}
