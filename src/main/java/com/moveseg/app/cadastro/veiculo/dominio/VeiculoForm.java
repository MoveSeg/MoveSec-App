package com.moveseg.app.cadastro.veiculo.dominio;

import java.util.function.Consumer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VeiculoForm {
    
    private final Consumer<VeiculoForm> action;

    public Placa placa;
    public Integer numeroDaFrota;
    public Chassi chassi;
    public Renavam renavam;
    public Integer anoModelo;
    public String marca;
    public String modelo;
    public String corPredominante;
    public Integer capacidadeDePassageiros;

    public VeiculoForm placa(Placa placa) {
        this.placa = placa;
        return this;
    }

    public VeiculoForm numeroDaFrota(Integer numeroDaFrota) {
        this.numeroDaFrota = numeroDaFrota;
        return this;
    }

    public VeiculoForm chassi(Chassi chassi) {
        this.chassi = chassi;
        return this;
    }

    public VeiculoForm renavam(Renavam renavam) {
        this.renavam = renavam;
        return this;
    }

    public VeiculoForm anoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
        return this;
    }

    public VeiculoForm marca(String marca) {
        this.marca = marca;
        return this;
    }

    public VeiculoForm modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VeiculoForm corPredominante(String corPredominante) {
        this.corPredominante = corPredominante;
        return this;
    }

    public VeiculoForm capacidadeDePassageiros(Integer capacidadeDePassageiros) {
        this.capacidadeDePassageiros = capacidadeDePassageiros;
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
