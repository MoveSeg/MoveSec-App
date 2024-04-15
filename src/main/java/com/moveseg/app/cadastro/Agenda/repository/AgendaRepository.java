package com.moveseg.app.cadastro.Agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.cadastro.Agenda.domain.Agenda;
import com.moveseg.app.cadastro.Agenda.domain.AgendaId;

public interface AgendaRepository extends JpaRepository<Agenda, AgendaId> {
}

