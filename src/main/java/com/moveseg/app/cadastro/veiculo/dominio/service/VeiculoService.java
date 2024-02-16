package com.moveseg.app.cadastro.veiculo.dominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;
import com.moveseg.app.cadastro.veiculo.dominio.VeiculoId;
import com.moveseg.app.cadastro.veiculo.dominio.repository.VeiculoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VeiculoService {
    
    private final VeiculoRepository repository;

    public Veiculo salvar (Veiculo veiculo){
        return repository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Veiculo> buscarPorId(VeiculoId id) {
        return repository.findById(id);
    }

    public void deletar (String id) {}
}