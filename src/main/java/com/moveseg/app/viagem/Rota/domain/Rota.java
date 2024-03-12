package com.moveseg.app.viagem.Rota.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Rota extends AbstractEntity<RotaId> {

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Endereco> enderecos;

    @Embedded
    @AttributeOverride(column = @Column(name = "numero"), name = "value")
    private Numero numero;

    private VeiculoId veiculo;

    private Rota(RotaId id, Numero numero, VeiculoId veiculo, List<Endereco> enderecos) {
        super(id);
        this.numero = requireNonNull(numero, "O numero não deve ser nulo");
        this.veiculo = requireNonNull(veiculo, "O veiculo não deve ser nulo");
    }

    public RotaForm update() {
        return new RotaForm(form -> {
            this.numero = requireNonNull(form.numero(), "Numero não pode ser nulo");
            this.veiculo = requireNonNull(form.veiculo(), "Veiculo não pode ser nulo");
        });

    }
        public static Rota of(Numero numero, VeiculoId veiculo, List<Endereco> enderecos) {
            RotaId id = randomId(RotaId.class);

            return new Rota(id, numero, veiculo, enderecos);

        }
    }
