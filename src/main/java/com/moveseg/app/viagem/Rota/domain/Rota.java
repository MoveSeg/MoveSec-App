package com.moveseg.app.viagem.Rota.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Rota extends AbstractEntity<RotaId> {

    @ElementCollection
    @CollectionTable(name = "enderecos", joinColumns = @JoinColumn(name = "rota_id"))
    private List<Endereco> enderecos;

    @Embedded
    @AttributeOverride(column = @Column(name = "numero"), name = "value")
    private Numero numero;

    private VeiculoId veiculo;

    private Rota(RotaId id, Numero numero, VeiculoId veiculo, List<Endereco> enderecos) {
        super(id);
        this.numero = requireNonNull(numero, "O numero não deve ser nulo");
        this.veiculo = requireNonNull(veiculo, "O veiculo não deve ser nulo");
        this.enderecos = requireNonNull(enderecos, "Endereco não pode ser nulo");
    }

    public RotaForm atualizar() {
        return new RotaForm(form -> {
            this.numero = requireNonNull(form.numero(), "Numero não pode ser nulo");
            this.veiculo = requireNonNull(form.veiculo(), "Veiculo não pode ser nulo");
            if (form.endereco().isEmpty()) {
                throw new IllegalArgumentException("Não pode ser nulo");
            }
            this.enderecos = requireNonNull(form.endereco(), "Endereco não pode ser nulo");
        });

    }

    public static Rota of(Numero numero, VeiculoId veiculo, List<Endereco> enderecos) {
        RotaId id = randomId(RotaId.class);

        return new Rota(id, numero, veiculo, enderecos);

    }
}
