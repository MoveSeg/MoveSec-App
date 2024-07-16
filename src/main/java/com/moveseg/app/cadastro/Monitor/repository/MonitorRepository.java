package com.moveseg.app.cadastro.Monitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, MonitorId> {

}