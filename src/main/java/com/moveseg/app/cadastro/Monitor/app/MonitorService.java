package com.moveseg.app.cadastro.Monitor.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;
import com.moveseg.app.cadastro.Monitor.domain.cmd.AtualizarMonitor;
import com.moveseg.app.cadastro.Monitor.domain.cmd.CriarMonitor;
import com.moveseg.app.cadastro.Monitor.repository.MonitorRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@RequiredArgsConstructor
public class MonitorService {

    private MonitorRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public MonitorId handle(@NonNull @Valid CriarMonitor cmd) throws Exception {
        Monitor monitor = Monitor.builder()
                .nome(cmd.nome)
                .dataDeNascimento(cmd.dataDeNascimento)
                .email(cmd.email)
                .telefone(cmd.telefone)
                .endereco(cmd.endereco)
                .genero(cmd.genero)
                .cpf(cmd.cpf)
                .build();

        repository.save(monitor);
        return monitor.id();
    }

    public Monitor atualizarMonitor(@NonNull MonitorId id, AtualizarMonitor cmd) throws Exception {
        Monitor monitor = repository.findById(id).orElseThrow(() -> new Exception("Não encontrado"));

        monitor.update()
                .nome(cmd.nome)
                .dataDeNascimento(cmd.dataDeNascimento)
                .email(cmd.email)
                .telefone(cmd.telefone)
                .endereco(cmd.endereco)
                .apply();
        return repository.save(monitor);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Monitor> listarTodos() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    @NonNull
    @Transactional(readOnly = true)
    public Monitor buscarPorId(@NonNull MonitorId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull MonitorId id) {
        repository.deleteById(id);
    }

}
