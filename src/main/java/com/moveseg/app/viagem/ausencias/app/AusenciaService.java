package com.moveseg.app.viagem.ausencias.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.ausencias.app.view.AusenciaListView;
import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.AusenciaId;
import com.moveseg.app.viagem.ausencias.domain.cmd.RegistrarAusencia;
import com.moveseg.app.viagem.ausencias.repository.AusenciaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

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

    @NonNull
    @Transactional(readOnly = true)
    public List<AusenciaListView> listarTodos() {
        return repository.findAll().stream().map(AusenciaListView::of).toList();
    }

    @Transactional(readOnly = true)
    public AusenciaListView buscarPorId(@NonNull AusenciaId id) {
        Ausencia ausencia =  repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));

                                        return AusenciaListView.of(ausencia);
    }
}