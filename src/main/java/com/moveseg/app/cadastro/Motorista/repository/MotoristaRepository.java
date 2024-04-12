package com.moveseg.app.cadastro.Motorista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;

public interface MotoristaRepository  extends JpaRepository<Motorista, MotoristaId> {

    
}