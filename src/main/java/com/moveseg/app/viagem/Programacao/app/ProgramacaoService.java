package com.moveseg.app.viagem.Programacao.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.Programacao.app.view.ProgramacaoFormView;
import com.moveseg.app.viagem.Programacao.app.view.ProgramacaoListView;
import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;
import com.moveseg.app.viagem.Programacao.domain.cmd.CriarProgramacao;
import com.moveseg.app.viagem.Programacao.repository.ProgramacaoRepository;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.repository.ViagemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class ProgramacaoService {

    private ProgramacaoRepository repository;
    private ViagemRepository viagemRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public ProgramacaoId handle(@NonNull @Valid CriarProgramacao cmd) {
        Viagem viagem = viagemRepository.findById(cmd.viagem()).get();

        Programacao programacao = Programacao.from(viagem, cmd.data());

        repository.save(programacao);

        return programacao.id();
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<ProgramacaoListView> listarTodos() {
        return repository.findAll().stream().map(ProgramacaoListView::of).toList();
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Programacao> agenda() {
        return repository.findAll()
                .stream()
                .filter(programacao -> programacao.data().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProgramacaoFormView buscarPorId(@NonNull ProgramacaoId id) {
        Programacao programacao = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", id.toUUID())));
        return ProgramacaoFormView.of(programacao);
    }

    public void deletar(@NonNull ProgramacaoId id) {
        repository.deleteById(id);
    }
}
