package com.moveseg.app.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.moveseg.app.cadastro.repository.VeiculoRepository;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cmd.AtualizarVeiculo;
import com.moveseg.app.cmd.CriarVeiculo;

// import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;
// import com.moveseg.app.cadastro.veiculo.dominio.VeiculoId;
// import com.moveseg.app.cadastro.veiculo.dominio.repository.VeiculoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;

    public Veiculo salvar(CriarVeiculo cmd) throws Exception {
        Veiculo veiculo = Veiculo.builder().
        placa(cmd.placa).
        numeroDaFrota(cmd.numeroDaFrota).
        chassi(cmd.chassi).
        renavam(cmd.renavam).
        anoModelo(cmd.anoModelo).
        marca(cmd.marca).
        modelo(cmd.modelo).
        corPredominante(cmd.corPredominante).
        capacidadeDePassageiros(cmd.capacidadeDePassageiros).
        build();
        return repository.save(veiculo);
    }

    public Veiculo atualizarVeiculo(VeiculoId id,  AtualizarVeiculo cmd) {
        Veiculo veiculo = repository.findById(id).get();
        veiculo.update()
        .placa(cmd.placa)
        .numeroDaFrota(cmd.numeroDaFrota)
        .chassi(cmd.chassi)
        .renavam(cmd.renavam)
        .anoModelo(cmd.anoModelo)
        .marca(cmd.marca)
        .modelo(cmd.modelo)
        .corPredominante(cmd.corPredominante)
        .capacidadeDePassageiros(cmd.capacidadeDePassageiros)
        .apply();
        return repository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Veiculo> buscarPorId(VeiculoId id) {
        return repository.findById(id);
    }

    public void deletar(VeiculoId id) {
        repository.deleteById(id);
    }

   
}
