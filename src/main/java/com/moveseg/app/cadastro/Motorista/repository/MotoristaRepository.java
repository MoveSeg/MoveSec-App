package com.moveseg.app.cadastro.Motorista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;

@Repository
public interface MotoristaRepository  extends JpaRepository<Motorista, MotoristaId> {

    
}