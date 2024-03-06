package com.moveseg.app.viagem.Ocorrencia.domain;

import static java.util.Objects.requireNonNull;
import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.Ocorrencia.events.OcorrenciaRealizada;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;


import jakarta.persistence.Entity;

import lombok.AccessLevel;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ocorrencia extends AbstractAggregateRoot<OcorrenciaId> {

    private String motivo;
    private LocalDate data;
    private ViagemId viagem;
    private AlunoId aluno;


    private Ocorrencia(OcorrenciaId id, String motivo, ViagemId viagem, AlunoId aluno) {
        super(id);
        this.motivo = requireNonNull(motivo, "O motivo não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "A viagem não deve ser nula");
        this.aluno = requireNonNull(aluno, "O aluno não deve ser nulo");
    }

    public static Ocorrencia of(String motivo, ViagemId viagem, AlunoId aluno) {
        OcorrenciaId id = randomId(OcorrenciaId.class);

        Ocorrencia ocorrencia = new Ocorrencia(id, motivo, viagem, aluno);
        ocorrencia.registerEvent(OcorrenciaRealizada.of(id));

           return ocorrencia;
       }

   }


