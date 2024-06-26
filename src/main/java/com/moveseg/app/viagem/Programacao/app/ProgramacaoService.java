package com.moveseg.app.viagem.Programacao.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;
import com.moveseg.app.viagem.Programacao.domain.cmd.CriarProgramacao;
import com.moveseg.app.viagem.Programacao.repository.ProgramacaoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class ProgramacaoService {

    private ProgramacaoRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public ProgramacaoId handle(@NonNull @Valid CriarProgramacao cmd) {

        Programacao programacao = Programacao.from(cmd.viagem(), cmd.data());

        repository.save(programacao);

        return programacao.id();
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Programacao> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Programacao buscarPorId(@NonNull ProgramacaoId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull ProgramacaoId id) {
        repository.deleteById(id);
    }
}
