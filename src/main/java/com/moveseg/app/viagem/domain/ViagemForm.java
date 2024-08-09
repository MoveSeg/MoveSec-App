package com.moveseg.app.viagem.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.viagem.Rota.domain.Rota;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ViagemForm {
    private final Consumer<ViagemForm> action;

    private List<Aluno> alunos = new ArrayList<Aluno>();
    private Rota rota;
    private Motorista motorista;
    private Veiculo veiculo;
    private LocalDate data;

    public ViagemForm alunos(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
        return this;
    }

    public ViagemForm rota(Rota rota) {
        this.rota = rota;
        return this;
    }

    public ViagemForm motorista(Motorista motorista) {
        this.motorista = motorista;
        return this;
    }

    public ViagemForm veiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return this;
    }

    public ViagemForm data(LocalDate data) {
        this.data = data;
        return this;
    }

    public void aplicar() {
        action.accept(this);
    }
}
