package com.moveseg.app.cadastro.Agenda.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Agenda.domain.Agenda;
import com.moveseg.app.cadastro.Agenda.domain.AgendaForm;
import com.moveseg.app.cadastro.Agenda.domain.AgendaId;
import com.moveseg.app.cadastro.Agenda.domain.cmd.AlterarAgenda;
import com.moveseg.app.cadastro.Agenda.domain.cmd.CriarAgenda;
import com.moveseg.app.cadastro.Agenda.repository.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class AgendaService {

    private AgendaRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public AgendaId handle(@NonNull @Valid CriarAgenda cmd) {

        Agenda agenda = Agenda.from(cmd.viagem(), cmd.data());

        repository.save(agenda);

        return agenda.id();
    }

    public Agenda handle(@NonNull @Valid AlterarAgenda cmd) {
        Agenda agenda = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", cmd.id().toUUID())));
        Agenda.atualizar()
                .data(cmd.data())
                .viagem(cmd.viagem())
                .aplicar();

        return repository.save(agenda);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<Agenda> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Agenda buscarPorId(@NonNull AgendaId id) {
        return repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", id.toUUID())));
    }

    public void deletar(@NonNull AgendaId id) {
        repository.deleteById(id);
    }
}
