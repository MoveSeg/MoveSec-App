package com.moveseg.app.checklist.Checklist.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.Checklist.app.view.ChecklistFormView;
import com.moveseg.app.checklist.Checklist.app.view.ChecklistListView;
import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Checklist.domain.cmd.AlterarChecklist;
import com.moveseg.app.checklist.Checklist.domain.cmd.CriarChecklist;
import com.moveseg.app.checklist.Checklist.repository.ChecklistRepository;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.app.checklist.Item.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

public class ChecklistService {
    private ChecklistRepository repository;
    private ItemRepository itemRepository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public ChecklistId handle(@NonNull @Valid CriarChecklist cmd) {
        List<Item> itens = itemRepository.findAllById(cmd.itens().stream().map(ItemId::new).toList());

        Checklist checklist = Checklist.from(cmd.nome, itens);

        repository.save(checklist);

        return checklist.id();
    }

    public Checklist handle(@NonNull @Valid AlterarChecklist cmd) {
        Item itens = itemRepository.findById((ItemId) cmd.itens()).get();
        Checklist checklist = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", cmd.id().toUUID())));
        checklist.atualizar()
                .nome(cmd.nome())
                .itens(itens)
                .aplicar();

        return repository.save(checklist);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<ChecklistListView> listarTodos() {
        return repository.findAll().stream().map(ChecklistListView::of).toList();
    }

    @Transactional(readOnly = true)
    public ChecklistFormView buscarPorId(@NonNull ChecklistId id) {
        Checklist checklist = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));
        return ChecklistFormView.of(checklist);

    }

    public void deletar(@NonNull ChecklistId id) {
        repository.deleteById(id);
    }

}
