package com.moveseg.app.viagem.ausencias.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.AusenciaId;
import com.moveseg.app.viagem.ausencias.domain.cmd.RegistrarAusencia;
import com.moveseg.app.viagem.ausencias.repository.AusenciaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class AusenciaService {

    private AusenciaRepository repository;

    @Lock(PESSIMISTIC_READ)
    public AusenciaId handle(@NonNull @Valid RegistrarAusencia cmd) throws Exception {
        Ausencia ausencia = Ausencia.from(cmd.viagem(), cmd.motivo(), cmd.aluno());

        repository.save(ausencia);
        return ausencia.id();
    }
}