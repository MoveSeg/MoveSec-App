package com.moveseg.app.cadastro.Instituto.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.Instituto.domain.cmd.AlterarInstituto;
import com.moveseg.app.cadastro.Instituto.domain.cmd.CriarInstituto;
import com.moveseg.app.cadastro.Instituto.repository.InstitutoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class InstitutoService {

    private InstitutoRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public InstitutoId handle(@NonNull @Valid CriarInstituto cmd) {

        Instituto instituto = Instituto.builder()
                .nome(cmd.nome())
                .endereco(cmd.endereco())
                .responsavel(cmd.responsavel())
                .telefone(cmd.telefone())
                .email(cmd.email())
                .build();

        repository.save(instituto);

        return instituto.id();
    }

    public Instituto handle(@NonNull @Valid AlterarInstituto cmd) {
        Instituto instituto = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", cmd.id().toUUID())));
        instituto.atualizar()
                .nome(cmd.nome())
                .endereco(cmd.endereco())
                .responsavel(cmd.responsavel())
                .telefone(cmd.telefone())
                .email(cmd.email())
                .aplicar();

        return repository.save(instituto);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Instituto> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Instituto buscarPorId(@NonNull InstitutoId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull InstitutoId id) {
        repository.deleteById(id);
    }
}
