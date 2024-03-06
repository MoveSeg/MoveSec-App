package com.moveseg.app.viagem.Ocorrencia.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.app.viagem.Ocorrencia.domain.cmd.CriarOcorrencia;
import com.moveseg.app.viagem.Ocorrencia.events.OcorrenciaRealizada;
import com.moveseg.app.viagem.Ocorrencia.repository.OcorrenciaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class OcorrenciaService {

    private OcorrenciaRepository repository;

    @Lock(PESSIMISTIC_READ)
    public OcorrenciaId handle(@NonNull @Valid CriarOcorrencia cmd) throws Exception {
        Ocorrencia ocorrencia = Ocorrencia.of(cmd.motivo(), cmd.viagem());

        repository.save(ocorrencia);
        return ocorrencia.id();
    }
}