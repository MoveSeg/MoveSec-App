package com.moveseg.app.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;

public interface ViagemRepository  extends JpaRepository<Viagem, ViagemId> {
    
}
