package com.moveseg.app.cadastro.veiculo.dominio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID>{
    
}
