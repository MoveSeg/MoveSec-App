package com.moveseg.app.checklist.Checklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;

public interface ChecklistRepository extends JpaRepository<Checklist, ChecklistId>{

    
}

