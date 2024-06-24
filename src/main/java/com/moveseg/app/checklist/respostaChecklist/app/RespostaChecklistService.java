package com.moveseg.app.checklist.respostaChecklist.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.respostaChecklist.app.view.RespostaChecklistFormView;
import com.moveseg.app.checklist.respostaChecklist.app.view.RespostaChecklistListView;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklist;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklistId;
import com.moveseg.app.checklist.respostaChecklist.domain.cmd.CriarRespostaChecklist;
import com.moveseg.app.checklist.respostaChecklist.repository.RespostaChecklistRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class RespostaChecklistService {
    private RespostaChecklistRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public RespostaChecklistId handle(@NonNull @Valid CriarRespostaChecklist cmd) {

                RespostaChecklist respostaChecklist = RespostaChecklist.builder()
                                .grupoChecklist(cmd.grupoChecklist())
                                .checklist(cmd.checklist())
                                .item(cmd.item())
                                .IdUsuario(cmd.idUsuario())
                                .resposta(cmd.resposta())
                                .data(cmd.data())
                                .build();

                repository.save(respostaChecklist);

        return respostaChecklist.id();
    }
    
    @NonNull
    @Transactional(readOnly = true)
    public List<RespostaChecklistListView> listarTodos() {
        return repository.findAll().stream().map(RespostaChecklistListView::of).toList();
    }

    @Transactional(readOnly = true)
    public RespostaChecklistFormView buscarPorId(@NonNull RespostaChecklistId id) {
        RespostaChecklist respostaChecklist = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));
        return RespostaChecklistFormView.of(respostaChecklist);

    }
}

    

    