package com.moveseg.app.viagem.Rota.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static java.util.Objects.requireNonNull;

import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.parent.infra.domain.AbstractEntity;

import jakarta.persistence.AttributeOverride;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
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

    private Numero numeroRota;

    

    private Rota(RotaId id, Numero numeroRota, List<Endereco> enderecos) {
        super(id);
        this.numeroRota = requireNonNull(numeroRota, "O numero da rota não deve ser nulo");
        this.enderecos = requireNonNull(enderecos, "Endereco não pode ser nulo");
    }

    public RotaForm atualizar() {
        return new RotaForm(form -> {
            this.numeroRota = requireNonNull(form.numeroRota(), "Numero não pode ser nulo");
            this.enderecos = requireNonNull(form.endereco(), "Endereco não pode ser nulo");
        });
    }

    public static Rota of(Numero numeroRota, List<Endereco> enderecos) {
        
        RotaId id = randomId(RotaId.class);
        return new Rota(id, numeroRota, enderecos);
    }
}
