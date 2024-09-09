package com.moveseg.app.checklist.Resposta.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.repository.ChecklistRepository;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.repository.GrupoChecklistRepository;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.repository.ItemRepository;
import com.moveseg.app.checklist.Resposta.app.view.RespostaListView;
import com.moveseg.app.checklist.Resposta.domain.Resposta;
import com.moveseg.app.checklist.Resposta.domain.RespostaId;
import com.moveseg.app.checklist.Resposta.domain.cmd.Responder;
import com.moveseg.app.checklist.Resposta.repository.RespostaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
@AllArgsConstructor
public class RespostaService {
    private RespostaRepository repository;
    private GrupoChecklistRepository grupoChecklistRepository;
    private ChecklistRepository checklistRepository;
    private ItemRepository itemRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public RespostaId handle(@NonNull @Valid Responder cmd) {
        GrupoChecklist grupoChecklist= grupoChecklistRepository.findById(cmd.grupoChecklist()).get();
        Checklist checklist= checklistRepository.findById(cmd.checklist()).get();
        Item item= itemRepository.findById(cmd.item()).get();
        Resposta resposta = Resposta.builder()
                .grupoChecklist(grupoChecklist)
                .checklist(checklist)
                .item(item)
                .IdUsuario(cmd.idUsuario())
                .resposta(cmd.resposta())
                .build();
                repository.save(resposta);

        return resposta.id();
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<RespostaListView> listarTodos() {
        return repository.findAll().stream().map(RespostaListView::of).toList();
    }
}