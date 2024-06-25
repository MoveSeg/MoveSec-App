package com.moveseg.app.checklist.resposta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.resposta.domain.Resposta;
import com.moveseg.app.checklist.resposta.domain.RespostaId;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, RespostaId> {

    
}
