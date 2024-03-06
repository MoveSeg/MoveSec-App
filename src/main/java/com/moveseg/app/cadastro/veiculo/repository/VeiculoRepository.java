package com.moveseg.app.cadastro.Veiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.Veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.Veiculo.domain.VeiculoId;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, VeiculoId> {

}
