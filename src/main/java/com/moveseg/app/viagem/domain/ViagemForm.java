package com.moveseg.app.viagem.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ViagemForm {
    private final Consumer<ViagemForm> action;
    private List<Aluno> alunos = new ArrayList();
    private RotaId rota;
    private MotoristaId motorista;
    private LocalDate data;

    public ViagemForm alunos(Aluno alunos) {
        this.alunos.add(alunos);
        return this;
    }

    public ViagemForm rota(RotaId rota) {
        this.rota = rota;
        return this;
    }

    public ViagemForm motorista(MotoristaId motorista) {
        this.motorista = motorista;
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
