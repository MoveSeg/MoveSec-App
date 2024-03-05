package com.moveseg.app.viagem.ausencias.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;

import com.moveseg.parent.infra.domain.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Ausencia extends AbstractEntity<AusenciaId> {

    private String motivo;
    private LocalDate data;

    private Ausencia(AusenciaBuilder builder) {
        super(builder.id);
        this.motivo = requireNonNull(builder.motivo, "O nome não deve ser nulo");
        this.data = requireNonNull(builder.data, "A data não pode ser nula");
    }

    public static class AusenciaBuilder {
        private AusenciaId id;

        public Ausencia build() {

            id = randomId(AusenciaId.class);

            return new Ausencia(this);
        }
    }
}
