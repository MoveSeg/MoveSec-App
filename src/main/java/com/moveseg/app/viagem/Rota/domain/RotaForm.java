package com.moveseg.app.viagem.Rota.domain;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RotaForm {

    private final Consumer<RotaForm> action;

    private List<Endereco> endereco = new ArrayList<Endereco>();;
    private Numero numero;
    private VeiculoId veiculo;

    public RotaForm numero(Numero numero) {
        this.numero = (numero);
        return this;
    }

    public RotaForm endereco(Endereco endereco) {
        this.endereco.add(endereco);
        return this;
    }

    public RotaForm veiculo(VeiculoId veiculo) {
        this.veiculo = (veiculo);
        return this;
    }

    public void apply() {
        action.accept(this);
    }
}
