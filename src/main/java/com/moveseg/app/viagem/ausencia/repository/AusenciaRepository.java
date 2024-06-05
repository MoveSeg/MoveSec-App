package com.moveseg.app.viagem.ausencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.viagem.ausencia.domain.Ausencia;
import com.moveseg.app.viagem.ausencia.domain.AusenciaId;

public interface AusenciaRepository extends JpaRepository<Ausencia, AusenciaId> {
   
}