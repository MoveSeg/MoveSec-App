package com.moveseg.app.cadastro.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.instituto.domain.Instituto;
import com.moveseg.app.cadastro.instituto.domain.InstitutoId;

public interface InstitutoRepository extends JpaRepository<Instituto, InstitutoId> {
}

