package com.moveseg.app.cadastro.responsavel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, ResponsavelId> {

    
}
