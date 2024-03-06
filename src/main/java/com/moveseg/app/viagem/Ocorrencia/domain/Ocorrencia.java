package com.moveseg.app.viagem.Ocorrencia.domain;

import static java.util.Objects.requireNonNull;
import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;

import java.time.LocalDate;

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


    private Ocorrencia(OcorrenciaId id, String motivo, ViagemId viagem) {
        super(id);
        this.motivo = requireNonNull(motivo, "O motivo não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "A viagem não deve ser nula");
    }

    public static Ocorrencia of(String motivo, ViagemId viagem) {
        OcorrenciaId id = randomId(OcorrenciaId.class);

        Ocorrencia ocorrencia = new Ocorrencia(id, motivo, viagem);
        ocorrencia.registerEvent(OcorrenciaRealizada.of(id));

           return ocorrencia;
       }

   }


