package com.moveseg.app.viagem.Ocorrencia.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.viagem.Ocorrencia.domain.events.OcorrenciaRealizada;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ocorrencia extends AbstractAggregateRoot<OcorrenciaId> {
    private String motivo;
    private LocalDate data;
    
    @ManyToOne
    private Viagem viagem;
    
    @ManyToOne
    private Aluno aluno;

    private Ocorrencia(OcorrenciaId id, String motivo, Viagem viagem, Aluno aluno) {
        super(id);
        this.motivo = requireNonNull(motivo, "O motivo não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "A viagem não deve ser nula");
        this.aluno = requireNonNull(aluno, "O aluno não deve ser nulo");
    }

    public static Ocorrencia of(String motivo, Viagem viagem, Aluno aluno) {
        OcorrenciaId id = randomId(OcorrenciaId.class);

        Ocorrencia ocorrencia = new Ocorrencia(id, motivo, viagem, aluno);
        ocorrencia.registerEvent(OcorrenciaRealizada.of(id));

           return ocorrencia;
       }

   }


