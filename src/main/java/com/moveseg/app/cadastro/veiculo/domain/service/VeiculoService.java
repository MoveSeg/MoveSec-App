package com.moveseg.app.cadastro.veiculo.domain.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Service;

import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cadastro.veiculo.domain.repository.VeiculoRepository;

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

    //Veiculo veiculo = Veiculo.builder().marca(veiculo.marca).build();

    public Veiculo salvar(Veiculo veiculo) {
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