package com.moveseg.app.cadastro.Motorista.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.Motorista.domain.cmd.AlterarMotorista;
import com.moveseg.app.cadastro.Motorista.domain.cmd.CriarMotorista;
import com.moveseg.app.cadastro.Motorista.repository.MotoristaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@RequiredArgsConstructor
public class MotoristaService {
    private final MotoristaRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public MotoristaId handle(@NonNull @Valid CriarMotorista cmd) throws Exception {
        Motorista motorista = Motorista.builder()
                .nome(cmd.nome)
                .nascimento(cmd.nascimento)
                .email(cmd.email)
                .telefone(cmd.telefone)
                .endereco(cmd.endereco)
                .genero(cmd.genero)
                .cpf(cmd.cpf)
                .build();

        repository.save(motorista);
        return motorista.id();
    }

    public Motorista handle(@NonNull @Valid AlterarMotorista cmd) {
        Motorista motorista = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        cmd.id().toUUID())));
        motorista.atualizar()
        .nome(cmd.nome)
        .nascimento(cmd.nascimento)
        .email(cmd.email)
        .telefone(cmd.telefone)
        .endereco(cmd.endereco)
        .genero(cmd.genero)
        .cpf(cmd.cpf)
        .aplicar();
        return repository.save( motorista);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Motorista> listarTodos() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    @NonNull
    @Transactional(readOnly = true)
    public Motorista buscarPorId(@NonNull MotoristaId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull MotoristaId id) {
        repository.deleteById(id);
    }
}
