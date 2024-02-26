package com.moveseg.app.cadastro.Aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;

public interface AlunoRepository extends JpaRepository<Aluno, AlunoId> {

}