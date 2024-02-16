package com.moveseg.app.cadastro.veiculo.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.veiculo.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {

}
