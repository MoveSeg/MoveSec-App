package com.moveseg.app.cadastro.veiculo.dominio;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;


import com.moveseg.parent.infra.domain.AbstractEntity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Veiculo extends AbstractEntity<VeiculoId> {

    @NotBlank
    @Embedded
    private final Placa placa;

    @NotBlank
    private final Integer numeroDaFrota;

    @NotBlank
    @Embedded
    private final Chassi chassi;

    @NotBlank
    private final Renavam renavam;

    @NotBlank
    private final Integer anoModelo;

    @NotBlank
    private final String marca;

    @NotBlank
    private final String modelo;

    @NotBlank
    private final String corPredominante;

    @NotBlank
    private final Integer capacidadeDePassageiros;

    @Builder
    private Veiculo(Placa placa, Integer numeroDaFrota, Chassi chassi, Renavam renavam, Integer anoModelo,
            String marca,
            String modelo, String corPredominante, Integer capacidadeDePassageiros) throws Exception {

        super(randomId(VeiculoId.class));

        if (placa == null)
            throw new Exception("A placa não deve ser nula");

        if (numeroDaFrota == null || numeroDaFrota == 0)
            throw new Exception("Número da frota inválido");

        if (chassi == null)
            throw new Exception("O chassi não deve ser nulo");

        if (renavam == null)
            throw new Exception("O renavam não deve ser nulo");

        if (anoModelo == null || anoModelo == 0)
            throw new Exception("O anoModelo não deve ser nulo");

        if (marca.isEmpty())
            throw new Exception(" A marca não deve ser nula");

        if (modelo.isEmpty())
            throw new Exception("O modelo não deve ser nulo");

        if (corPredominante.isEmpty())
            throw new Exception("A cor predominate não deve ser nula");

        if (capacidadeDePassageiros == null || capacidadeDePassageiros == 0)
            throw new Exception("A capacidade de passageiros não deve ser nula");

        this.placa = placa;
        this.numeroDaFrota = numeroDaFrota;
        this.chassi = chassi;
        this.renavam = renavam;
        this.anoModelo = anoModelo;
        this.marca = marca;
        this.modelo = modelo;
        this.corPredominante = corPredominante;
        this.capacidadeDePassageiros = capacidadeDePassageiros;
    }
}