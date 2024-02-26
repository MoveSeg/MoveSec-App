package com.moveseg.app.cadastro.responsavel.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;
import com.moveseg.app.cadastro.responsavel.domain.cmd.AtualizarResponsavel;
import com.moveseg.app.cadastro.responsavel.domain.cmd.CriarResponsavel;
import com.moveseg.app.cadastro.responsavel.repository.ResponsavelRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public ResponsavelId handle(@NonNull @Valid CriarResponsavel cmd) throws Exception {
        Responsavel responsavel = Responsavel.builder()
                .nome(cmd.nome)
                .documento(cmd.documento)
                .nascimento(cmd.nascimento)
                .email(cmd.email)
                .telefone(cmd.telefone)
                .endereco(cmd.endereco)
                .genero (cmd.genero)
                .cpf(cmd.cpf)
                .build();

        repository.save(responsavel);
        return responsavel.id();
    }

    public Responsavel atualizarResponsavel(@NonNull ResponsavelId id, AtualizarResponsavel cmd) throws Exception {
        Responsavel responsavel = repository.findById(id).orElseThrow(() -> new Exception("Não encontrado"));

        responsavel.update()
                .nome(cmd.nome)
                .documento(cmd.documento)
                .nascimento(cmd.nascimento)
                .email(cmd.email)
                .telefone(cmd.telefone)
                .endereco(cmd.endereco)
                .apply();
        return repository.save(responsavel);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Responsavel> listarTodos() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    @NonNull
    @Transactional(readOnly = true)
    public Responsavel buscarPorId(@NonNull ResponsavelId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull ResponsavelId id) {
        repository.deleteById(id);
    }

}
