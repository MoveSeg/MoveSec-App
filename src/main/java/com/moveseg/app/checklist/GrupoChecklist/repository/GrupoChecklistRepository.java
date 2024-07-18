package com.moveseg.app.checklist.GrupoChecklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;

@Repository
public interface GrupoChecklistRepository extends JpaRepository<GrupoChecklist, GrupoChecklistId>{
    
}
