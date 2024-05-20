package com.moveseg.app.viagem.ausencias.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.viagem.ausencias.domain.eventos.AusenciaRegistrada;
import com.moveseg.app.viagem.domain.ViagemId;
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
    private ViagemId viagem;
    private Ausencia(AusenciaId id,ViagemId viagem, AlunoId aluno,  String motivo) {
        super(id);
        this.motivo = requireNonNull(motivo, "O nome não deve ser nulo");
        this.data = LocalDate.now();
        this.viagem = requireNonNull(viagem, "O Id da viagem não pode ser nula");
        this.aluno = requireNonNull(aluno, "O Id da viagem não pode ser nula");
    }

    @SuppressWarnings("null")
    public static Ausencia from(ViagemId viagem, String motivo, AlunoId aluno) {
        AusenciaId id = randomId(AusenciaId.class);

        Ausencia ausencia = new Ausencia(id, viagem, aluno, motivo);
        ausencia.registerEvent(AusenciaRegistrada.of(id));

        return ausencia;
    }
}
