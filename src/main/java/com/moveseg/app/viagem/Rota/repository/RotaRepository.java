package com.moveseg.app.viagem.Rota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;

@Repository
public interface RotaRepository extends JpaRepository<Rota, RotaId> {

}
