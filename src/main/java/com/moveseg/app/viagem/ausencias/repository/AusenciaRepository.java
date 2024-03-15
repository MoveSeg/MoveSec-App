package com.moveseg.app.viagem.ausencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.AusenciaId;

public interface AusenciaRepository extends JpaRepository<Ausencia, AusenciaId> {
   
}