package com.moveseg.app.cadastro.veiculo.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = PRIVATE, force = true)

@Entity
public class Veiculo extends AbstractEntity<VeiculoId> {

    @Embedded
    @AttributeOverride(column = @Column(name = "placa"), name = "value")
    private Placa placa;

    private Integer numeroDaFrota;

    @Embedded
    @AttributeOverride(column = @Column(name = "chassi"), name = "value")
    private Chassi chassi;

    @Embedded
    @AttributeOverride(column = @Column(name = "renavam"), name = "value")
    private Renavam renavam;

    private Integer anoModelo;

    private String marca;

    private String modelo;

    private String corPredominante;

    private Integer capacidadeDePassageiros;

    private Veiculo(VeiculoBuilder builder) {
        super(builder.id);
        this.placa = requireNonNull(builder.placa, "A placa não deve ser inválida");
        this.numeroDaFrota = requireNonNull(builder.numeroDaFrota, "Número da frota inválido");
        this.chassi = requireNonNull(builder.chassi, "O chassi não deve ser nulo");
        this.renavam = requireNonNull(builder.renavam, "O renavam não deve ser nulo");
        this.anoModelo = requireNonNull(builder.anoModelo, "O anoModelo não deve ser nulo");
        this.marca = requireNonNull(builder.marca, "A marca não deve ser nula");
        this.modelo = requireNonNull(builder.modelo, "O modelo não deve ser nulo");
        this.corPredominante = requireNonNull(builder.corPredominante, "A cor predominate não deve ser nula");
        this.capacidadeDePassageiros = requireNonNull(builder.capacidadeDePassageiros,
                "A capacidade de passageiros não deve ser nula");
    }

    public VeiculoForm update() {
        return new VeiculoForm(form -> {
            this.placa = requireNonNull(form.placa(), "O nome não deve ser inválido");
            this.numeroDaFrota = requireNonNull(form.numeroDaFrota(), "O nome não deve ser nulo");
            this.chassi = requireNonNull(form.chassi(), "O nome não deve ser nulo");
            this.renavam = requireNonNull(form.renavam(), "O nome não deve ser nulo");
            this.anoModelo = requireNonNull(form.anoModelo(), "O nome não deve ser nulo");
            this.marca = requireNonNull(form.marca(), "O nome não deve ser nulo");
            this.modelo = requireNonNull(form.modelo(), "O nome não deve ser nulo");
            this.corPredominante = requireNonNull(form.corPredominante(), "O nome não deve ser nulo");
            this.capacidadeDePassageiros = requireNonNull(form.capacidadeDePassageiros(), "O nome não deve ser nulo");
        });
    }

    public static class VeiculoBuilder {
        private VeiculoId id;

        public Veiculo build() {
            id = randomId(VeiculoId.class);

            return new Veiculo(this);
        }
    }
}