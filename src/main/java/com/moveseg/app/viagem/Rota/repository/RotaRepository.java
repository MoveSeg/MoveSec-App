package com.moveseg.app.viagem.Rota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;

public interface RotaRepository extends JpaRepository<Rota, RotaId> {

}
