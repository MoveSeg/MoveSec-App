package com.moveseg.app.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;

@Repository
public interface ViagemRepository  extends JpaRepository<Viagem, ViagemId> {
    
}
