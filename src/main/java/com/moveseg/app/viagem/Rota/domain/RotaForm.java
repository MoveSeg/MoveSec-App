package com.moveseg.app.viagem.Rota.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RotaForm {

    private final Consumer<RotaForm> action;

    private List<Endereco> endereco = new ArrayList<Endereco>();;
    private Numero numeroRota;
    private VeiculoId veiculo;

    public RotaForm numeroRota(Numero numeroRota) {
        this.numeroRota = (numeroRota);
        return this;
    }

    public RotaForm endereco(List<Endereco> endereco) {
        this.endereco.addAll(endereco);
        return this;
    }

    public RotaForm veiculo(VeiculoId veiculo) {
        this.veiculo = (veiculo);
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
