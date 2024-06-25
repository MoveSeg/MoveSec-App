package com.moveseg.app.checklist.Checklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.Checklist.domain.Resposta;
import com.moveseg.app.checklist.Checklist.domain.RespostaId;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, RespostaId> {

    
}
