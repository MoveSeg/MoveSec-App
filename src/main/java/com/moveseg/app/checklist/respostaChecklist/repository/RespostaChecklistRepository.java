package com.moveseg.app.checklist.respostaChecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklist;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklistId;

@Repository
public interface RespostaChecklistRepository extends JpaRepository<RespostaChecklist, RespostaChecklistId> {

    
}
