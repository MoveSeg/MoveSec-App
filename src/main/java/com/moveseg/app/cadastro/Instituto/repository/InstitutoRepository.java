package com.moveseg.app.cadastro.Instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;



public interface InstitutoRepository extends JpaRepository<Instituto, InstitutoId> {


    
} 