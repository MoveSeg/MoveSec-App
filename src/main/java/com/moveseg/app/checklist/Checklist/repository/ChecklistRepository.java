package com.moveseg.app.checklist.Checklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, ChecklistId>{

    
}

