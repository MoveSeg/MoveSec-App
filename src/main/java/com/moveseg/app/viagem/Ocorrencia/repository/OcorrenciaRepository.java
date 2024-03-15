package com.moveseg.app.viagem.Ocorrencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, OcorrenciaId> {

}
