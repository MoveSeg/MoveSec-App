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

import com.moveseg.app.cadastro.Monitor.app.view.MonitorFormView;
import com.moveseg.app.cadastro.Monitor.app.view.MonitorListView;
import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;
import com.moveseg.app.cadastro.Monitor.domain.cmd.AtualizarMonitor;
import com.moveseg.app.cadastro.Monitor.domain.cmd.CriarMonitor;
import com.moveseg.app.cadastro.Monitor.repository.MonitorRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class MonitorService {

    private MonitorRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public MonitorId handle(@NonNull @Valid CriarMonitor cmd) throws Exception {
        Monitor monitor = Monitor.builder()
                .nome(cmd.nome())
                .dataDeNascimento(cmd.dataDeNascimento())
                .email(cmd.email())
                .telefone(cmd.telefone())
                .endereco(cmd.endereco())
                .genero(cmd.genero())
                .cpf(cmd.cpf())
                .build();

        repository.save(monitor);
        return monitor.id();
    }

    public Monitor atualizarMonitor(@NonNull @Valid AtualizarMonitor cmd) throws Exception {
        Monitor monitor = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        cmd.id().toUUID())));
        monitor.update()
                .nome(cmd.nome())
                .dataDeNascimento(cmd.dataDeNascimento())
                .email(cmd.email())
                .telefone(cmd.telefone())
                .endereco(cmd.endereco())
                .genero(cmd.genero())
                .cpf(cmd.cpf())
                .apply();
        return repository.save(monitor);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<MonitorListView> listarTodos() {
        return repository.findAll().stream().map(MonitorListView::of).toList();
    }

    @Transactional(readOnly = true)
    public MonitorFormView buscarPorId(@NonNull MonitorId id) {
        return MonitorFormView.of(repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID()))));
    }

    public void deletar(@NonNull MonitorId id) {
        repository.deleteById(id);
    }

}
