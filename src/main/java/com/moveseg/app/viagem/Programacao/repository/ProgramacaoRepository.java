package com.moveseg.app.viagem.Programacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;

public interface ProgramacaoRepository extends JpaRepository<Programacao, ProgramacaoId> {
}

