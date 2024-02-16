package com.moveseg.app.cadastro.veiculo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;
import com.moveseg.app.cadastro.veiculo.dominio.VeiculoId;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, VeiculoId>{
    
}
