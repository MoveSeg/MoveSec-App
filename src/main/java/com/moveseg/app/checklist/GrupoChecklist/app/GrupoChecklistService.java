package com.moveseg.app.checklist.GrupoChecklist.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Checklist.repository.ChecklistRepository;
import com.moveseg.app.checklist.GrupoChecklist.app.list.GrupoChecklistFormView;
import com.moveseg.app.checklist.GrupoChecklist.app.list.GrupoChecklistListView;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.GrupoChecklist.domain.cmd.AlterarGrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.cmd.CriarGrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.repository.GrupoChecklistRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional()
@AllArgsConstructor
public class GrupoChecklistService {

    private GrupoChecklistRepository repository;
    private ChecklistRepository checklistRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public GrupoChecklistId handle(@NonNull @Valid CriarGrupoChecklist cmd) {
        List<Checklist> checklists = checklistRepository.findAllById(cmd.checklists().stream().map(ChecklistId::new).toList());

        GrupoChecklist grupoChecklist = GrupoChecklist.from(cmd.nome,checklists);

        repository.save(grupoChecklist);

        return grupoChecklist.id();
    }

    public GrupoChecklist handle(@NonNull @Valid AlterarGrupoChecklist cmd) {
        Checklist checklists = checklistRepository.findById((ChecklistId) cmd.checklists()).get();
        GrupoChecklist grupoChecklist = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", cmd.id().toUUID())));
                                grupoChecklist.atualizar()
                .nome(cmd.nome())
                .checklist(checklists)
                .aplicar();

        return repository.save(grupoChecklist);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<GrupoChecklistListView> listarTodos() {
        return repository.findAll().stream().map(GrupoChecklistListView::of).toList();
    }

    @Transactional(readOnly = true)
    public GrupoChecklistFormView buscarPorId(@NonNull GrupoChecklistId id) {
        GrupoChecklist grupoChecklist = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));
        return GrupoChecklistFormView.of(grupoChecklist);

    }

    public void deletar(@NonNull GrupoChecklistId id) {
        repository.deleteById(id);
    }    
}

