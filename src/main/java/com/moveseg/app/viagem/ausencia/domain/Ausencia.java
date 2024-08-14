package com.moveseg.app.viagem.ausencia.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.ausencia.domain.eventos.AusenciaRegistrada;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.parent.infra.domain.AbstractAggregateRoot;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Ausencia extends AbstractAggregateRoot<AusenciaId> {

    private String motivo;
    private LocalDate data;
    private AlunoId aluno;
    private Viagem viagem;
    private Ausencia(AusenciaId id, Viagem viagem, AlunoId aluno,  String motivo) {
        super(id);
        this.motivo = requireNonNull(motivo, "O Motivo não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "O Id da viagem não pode ser nula");
        this.aluno = requireNonNull(aluno, "O Id da viagem não pode ser nula");
    }

    public static Ausencia from(Viagem viagem, String motivo, AlunoId aluno) {
        AusenciaId id = randomId(AusenciaId.class);

        Ausencia ausencia = new Ausencia(id, viagem, aluno, motivo);
        ausencia.registerEvent(AusenciaRegistrada.of(id));

        return ausencia;
    }
}
