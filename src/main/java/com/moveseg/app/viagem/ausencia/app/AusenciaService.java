package com.moveseg.app.viagem.ausencia.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.repository.AlunoRepository;
import com.moveseg.app.viagem.ausencia.app.view.AusenciaFormView;
import com.moveseg.app.viagem.ausencia.app.view.AusenciaListView;
import com.moveseg.app.viagem.ausencia.domain.Ausencia;
import com.moveseg.app.viagem.ausencia.domain.AusenciaId;
import com.moveseg.app.viagem.ausencia.domain.cmd.RegistrarAusencia;
import com.moveseg.app.viagem.ausencia.repository.AusenciaRepository;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.repository.ViagemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class AusenciaService {

    private AusenciaRepository repository;
    private ViagemRepository viagemRepository;
    private AlunoRepository alunoRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public AusenciaId handle(@NonNull @Valid RegistrarAusencia cmd) throws Exception {
        Viagem viagem = viagemRepository.findById(cmd.viagem()).get();
        Aluno aluno = alunoRepository.findById(cmd.aluno()).get();
        Ausencia ausencia = Ausencia.from(viagem, cmd.motivo(), aluno);

        repository.save(ausencia);
        return ausencia.id();
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<AusenciaListView> listarTodos() {
        return repository.findAll().stream().map(AusenciaListView::of).toList();
    }

    @Transactional(readOnly = true)
    public AusenciaFormView buscarPorId(@NonNull AusenciaId id) {
        return AusenciaFormView.of(repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID()))));

    }
}