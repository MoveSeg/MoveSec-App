package com.moveseg.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.cadastroInstituicao.domain.Instituto;
import com.moveseg.app.cadastro.cadastroInstituicao.domain.InstitutoId;


public interface InstitutoRepository extends JpaRepository<Instituto, InstitutoId> {


    
} 