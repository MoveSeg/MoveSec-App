package com.moveseg.app.viagem.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class  Viagem extends AbstractEntity<ViagemId> {

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Aluno> alunos;

    @ManyToOne
    private Rota rota;

    @ManyToOne
    private Motorista motorista;

    @ManyToOne
    private Veiculo veiculo;
    private LocalDate data;

    private Viagem(ViagemBuilder builder) {
        super(builder.id);
        if (builder.alunos.isEmpty()) {
            throw new IllegalArgumentException("Não pode ser nulo");
        }
        this.alunos = requireNonNull(builder.alunos, "O aluno não deve ser nulo");
        this.rota = requireNonNull(builder.rota, "A rota não deve ser nula");
        this.motorista = requireNonNull(builder.motorista, "O motorista não deve ser nulo");
        this.veiculo = requireNonNull(builder.veiculo, "O veiculo não deve ser nulo");
        this.data = requireNonNull(builder.data, "A data não deve ser inválida e nem nula");
    }

    public ViagemForm atualizar() {
        return new ViagemForm(form -> {
            if (form.alunos().isEmpty()) {
                throw new IllegalArgumentException("Não pode ser nulo");
            }
            this.alunos = requireNonNull(form.alunos(), "O aluno não deve ser nulo");
            this.rota = requireNonNull(form.rota(), "A rota não deve ser nula");
            this.motorista = requireNonNull(form.motorista(), "O motorista não deve ser nulo");
            this.veiculo = requireNonNull(form.veiculo(), "O veiculo não deve ser nulo");
            this.data = requireNonNull(form.data(), "A data não deve ser inválida e nem nula");
        });
    }

    public static class ViagemBuilder {
        private ViagemId id;
        private List<Aluno> alunos = new ArrayList<Aluno>();

        public ViagemBuilder alunos(List<Aluno> alunos) {
            this.alunos.addAll(alunos);
            return this;
        }

        public Viagem build() {
            id = randomId(ViagemId.class);

            return new Viagem(this);
        }

    }

}
