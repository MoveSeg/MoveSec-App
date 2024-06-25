package com.moveseg.app.checklist.resposta.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.resposta.app.view.RespostaFormView;
import com.moveseg.app.checklist.resposta.app.view.RespostaListView;
import com.moveseg.app.checklist.resposta.domain.Resposta;
import com.moveseg.app.checklist.resposta.domain.RespostaId;
import com.moveseg.app.checklist.resposta.domain.cmd.Responder;
import com.moveseg.app.checklist.resposta.repository.RespostaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class RespostaService {
    private RespostaRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public RespostaId handle(@NonNull @Valid Responder cmd) {

                Resposta respostaChecklist = Resposta.builder()
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
    public List<RespostaListView> listarTodos() {
        return repository.findAll().stream().map(RespostaListView::of).toList();
    }

    @Transactional(readOnly = true)
    public RespostaFormView buscarPorId(@NonNull RespostaId id) {
        Resposta respostaChecklist = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));
        return RespostaFormView.of(respostaChecklist);

    }
}

    

    