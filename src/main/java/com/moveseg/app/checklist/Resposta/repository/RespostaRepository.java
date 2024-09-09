package com.moveseg.app.checklist.Resposta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.Resposta.domain.Resposta;
import com.moveseg.app.checklist.Resposta.domain.RespostaId;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, RespostaId> {

    
}
