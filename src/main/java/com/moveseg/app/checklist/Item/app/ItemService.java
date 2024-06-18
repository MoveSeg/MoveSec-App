package com.moveseg.app.checklist.Item.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.checklist.Item.app.view.ItemFormView;
import com.moveseg.app.checklist.Item.app.view.ItemListView;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.app.checklist.Item.domain.cmd.AlterarItem;
import com.moveseg.app.checklist.Item.domain.cmd.CriarItem;
import com.moveseg.app.checklist.Item.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class ItemService {

    private ItemRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public ItemId handle(@NonNull @Valid CriarItem cmd) {
        Item item = Item.from(cmd.descricao(), cmd.resposta(), cmd.observacao());

        repository.save(item);

        return item.id();
    }

    public Item handle(@NonNull @Valid AlterarItem cmd) {
        Item item = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.", cmd.id().toUUID())));
        item.atualizar()
                .descricao(cmd.descricao())
                .resposta(cmd.resposta())
                .observacao(cmd.observacao())
                .aplicar();

        return repository.save(item);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<ItemListView> listarTodos() {
        return repository.findAll().stream().map(ItemListView::of).toList();
    }

    @Transactional(readOnly = true)
    public ItemFormView buscarPorId(@NonNull ItemId id) {
        Item item = repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        id.toUUID())));
        return ItemFormView.of(item);

    }

    public void deletar(@NonNull ItemId id) {
        repository.deleteById(id);
    }
}
