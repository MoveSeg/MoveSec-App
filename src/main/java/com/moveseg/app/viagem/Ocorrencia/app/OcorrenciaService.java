package com.moveseg.app.viagem.Ocorrencia.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.Ocorrencia.app.view.OcorrenciaFormView;
import com.moveseg.app.viagem.Ocorrencia.app.view.OcorrenciaListView;
import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.app.viagem.Ocorrencia.domain.cmd.CriarOcorrencia;
import com.moveseg.app.viagem.Ocorrencia.repository.OcorrenciaRepository;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.repository.ViagemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class OcorrenciaService {

    private OcorrenciaRepository repository;
    private ViagemRepository viagemRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public OcorrenciaId handle(@NonNull @Valid CriarOcorrencia cmd) throws Exception {
        Viagem viagem = viagemRepository.findById(cmd.viagem()).get();
        Ocorrencia ocorrencia = Ocorrencia.of(cmd.motivo(), viagem, cmd.aluno());

        repository.save(ocorrencia);
        return ocorrencia.id();
    }

    @NonNull

    @Transactional(readOnly = true)
    public List<OcorrenciaListView> listarTodos() {
        return repository.findAll().stream().map(OcorrenciaListView::of).toList();
    }

    @Transactional(readOnly = true)
    public OcorrenciaFormView buscarPorId(@NonNull OcorrenciaId id) {
        return OcorrenciaFormView.of(repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID()))));
    }

}
